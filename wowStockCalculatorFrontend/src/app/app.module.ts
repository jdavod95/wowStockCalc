import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ResourceService } from 'src/app/services/resource.service';
import { HttpClientModule } from '@angular/common/http';
import { SaleService } from './services/sale.service';
import { ResourcesComponent } from './components/resources/resources.component';
import { SalesComponent } from './components/sales/sales.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    ResourcesComponent,
    SalesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    ResourceService,
    SaleService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
