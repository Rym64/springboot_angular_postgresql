import { Component, OnInit } from '@angular/core';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: any;
  image: File;
  //post = new PostObject();
  selectedFiles: FileList;
  currentFile: File;
  progress = 0;
  message = '';

  fileInfos: Observable<any>;

  constructor(private token: TokenStorageService, private userService: UserService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
    this.fileInfos = this.userService.getFiles();
  }

  //Upload image
  /*selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    this.progress = 0;

    this.currentFile = this.selectedFiles.item(0);
    this.userService.upload(this.currentFile).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.message = event.body.message;
          this.fileInfos = this.userService.getFiles();
        }
      },
      err => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      });

    this.selectedFiles = undefined;
  }
  */

  /*handleInputChange(event) {
    console.log(event);
    this.image = event.target.files[0];

    var pattern = /image-*/;

   /* if (!this.image.type.match(pattern)) {
        console.log('File is not an image');
        return;
    }
    this.post.postPhoto = this.image;

    console.log('image :' + this.image);
}*/

}
