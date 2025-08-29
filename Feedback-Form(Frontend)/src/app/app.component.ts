import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FeedbackFormComponent } from './feedback-form/feedback-form.component';

@Component({
  selector: 'app-root',
  standalone: true, // ✅ important for standalone components
  imports: [RouterOutlet, FeedbackFormComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'], // ✅ should be styleUrls (array)
})
export class AppComponent {
  title = 'Angular_Assignment';
}
