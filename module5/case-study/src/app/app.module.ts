import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderToplineComponent } from './components/header-topline/header-topline.component';
import { HeaderContentComponent } from './components/header-content/header-content.component';
import { NavbarStickyComponent } from './components/navbar-sticky/navbar-sticky.component';
import { BottombarNotificationComponent } from './components/bottombar-notification/bottombar-notification.component';
import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderToplineComponent,
    HeaderContentComponent,
    NavbarStickyComponent,
    BottombarNotificationComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
