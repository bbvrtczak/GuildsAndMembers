import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { GuildListComponent } from './guild/view/guild-list/guild-list.component';
import { HttpClientModule } from "@angular/common/http";
import { GuildService } from "./guild/service/guild.service";
import { MemberListComponent } from './member/view/member-list/member-list.component';
import { MemberService } from './member/service/member.service';
import { MemberViewComponent } from './member/view/member-view/member-view.component';
import { MemberEditComponent } from './member/view/member-edit/member-edit.component';
import { FormsModule } from "@angular/forms";
import {GuildViewComponent} from "./guild/view/guild-view/guild-view.component";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    GuildListComponent,
    GuildViewComponent,
    MemberListComponent,
    MemberViewComponent,
    MemberEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    MemberService,
    GuildService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
