import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // ✅ for *ngIf, *ngFor
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

@Component({
  selector: 'app-feedback-form',
  standalone: true, // ✅ standalone component
  imports: [
    CommonModule, // ✅ gives *ngIf, *ngFor
    ReactiveFormsModule, // ✅ gives formGroup, formControlName
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

  constructor(private fb: FormBuilder) {
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
      this.submitted = true;
      console.log(this.feedbackForm.value);
      this.feedbackForm.reset();
    }
  }
}
