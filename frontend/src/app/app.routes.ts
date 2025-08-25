import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { Component } from '@angular/core';
import { HotelsComponent } from './pages/hotels/hotels.component';
import { ExperienceComponent } from './pages/experience/experience.component';
import { AboutComponent } from './pages/about/about.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'hotels', component: HotelsComponent },
  { path: 'experience', component: ExperienceComponent },
  { path: 'about', component: AboutComponent },
  { path: '**', redirectTo: '' }, // fallback route
];
