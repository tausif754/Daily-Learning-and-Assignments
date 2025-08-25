import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MusicListComponent } from './music-list/music-list.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MusicListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'Music-App';
}
