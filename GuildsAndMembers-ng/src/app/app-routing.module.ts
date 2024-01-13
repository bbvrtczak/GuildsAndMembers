import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuildListComponent } from "./guild/view/guild-list/guild-list.component";
import { MemberListComponent } from "./member/view/member-list/member-list.component";
import { MemberViewComponent } from "./member/view/member-view/member-view.component";
import { MemberEditComponent } from "./member/view/member-edit/member-edit.component";
import {GuildViewComponent} from "./guild/view/guild-view/guild-view.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: GuildListComponent,
    path: "guilds"
  },
  {
    component: GuildViewComponent,
    path: "guilds/:uuid"
  },
  {
    component: MemberListComponent,
    path: "members"
  },
  {
    component: MemberViewComponent,
    path: "members/:uuid"
  }
  ,
  {
    component: MemberEditComponent,
    path: "members/:uuid/edit"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
