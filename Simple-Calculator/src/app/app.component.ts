import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [MatButtonModule, MatInputModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  num1: number = 0;
  num2: number = 0;
  result: number = 0;

  add() {
    this.result = this.num1 + this.num2;
  }
  subtract() {
    this.result = this.num1 - this.num2;
  }
  multiply() {
    this.result = this.num1 * this.num2;
  }
  divide() {
    this.result = this.num2 !== 0 ? this.num1 / this.num2 : NaN;
  }
}
