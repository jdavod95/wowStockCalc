import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Resource } from 'src/app/domain/resource';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ResourceService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getResources(): Observable<Resource[]> {
    return this.http.get<Resource[]>(`${this.apiServerUrl}/resources`);
  }

  public getResource(resourceId: number): Observable<Resource> {
    return this.http.get<Resource>(`${this.apiServerUrl}/resources/${resourceId}`);
  }

  public addResource(resource: Resource): Observable<Resource> {
    return this.http.put<Resource>(`${this.apiServerUrl}/resources`, resource);
  }

  public updateResource(resource: Resource): Observable<Resource> {
    return this.http.patch<Resource>(`${this.apiServerUrl}/resources/${resource.id}`, resource);
  }

  public deleteResources(resourceId: number): Observable<any> {
    return this.http.delete<void>(`${this.apiServerUrl}/resources/${resourceId}`);
  }
}
