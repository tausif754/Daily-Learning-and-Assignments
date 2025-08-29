import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { HttpClient } from '@angular/common/http'; // ✅ Only HttpClient

@Component({
  selector: 'app-feedback-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
  ],
  templateUrl: './feedback-form.component.html',
  styleUrls: ['./feedback-form.component.css'],
})
export class FeedbackFormComponent {
  feedbackForm: FormGroup;
  submitted = false;
  successMessage = '';
  errorMessage = '';

  private apiUrl = 'http://localhost:8080/api/feedback'; // ✅ Spring Boot API

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.feedbackForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      subject: ['', [Validators.required, Validators.maxLength(40)]],
      comments: ['', [Validators.required, Validators.maxLength(350)]],
    });
  }

  get f() {
    return this.feedbackForm.controls;
  }

  onSubmit() {
    if (this.feedbackForm.valid) {
      this.http
        .post(this.apiUrl, this.feedbackForm.value, { responseType: 'text' })
        .subscribe({
          next: (res) => {
            this.submitted = true;
            this.successMessage = res;
            this.errorMessage = '';
            this.feedbackForm.reset();
          },
          error: () => {
            this.errorMessage = '❌ Something went wrong! Try again.';
            this.successMessage = '';
          },
        });
    }
  }
}
