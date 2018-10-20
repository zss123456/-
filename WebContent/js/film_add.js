/*
* 上传影片图片
* */
var dataURL;
function preview() {

    var imgContent = document.getElementById('img-content');
    if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (evt) {
            //console.log(evt.target.result);
            dataURL = evt.target.result;
            imgContent.innerHTML = '<img src="' + evt.target.result + '" />';
        }
        reader.readAsDataURL(this.files[0]);
    }
}

/*
* 获取弹出式窗口的按钮
* */
var logOffFilm = document.getElementById("log-off-film");    //退出按钮
var filmReset = document.getElementById("film-reset");       //重置按钮
var filmConfirm = document.getElementById("film-confirm");   //提交按钮
var filmAdd = document.getElementById("film-add");           //窗口ID
var addFilm = document.getElementById("add-film");           //弹出按钮
var turnOff = document.getElementById("turn-off");           //添加是否成功提示按钮
var imageFilm = document.getElementById("image-film");

imageFilm.onchange = preview;

/*
* 获取上架影片信息
* */
var directorFilm = document.getElementById("director-film");
var typeFilm = document.getElementById("type-film");
var areaFilm = document.getElementById("area-film");
var languageFilm = document.getElementById("language-film");
var sheetLengthFilm = document.getElementById("sheet-length-film");
var actorFilm = document.getElementById("actor-film");
var nameFilm = document.getElementById("name-film");
var imageFilm = document.getElementById("image-film");

/*
* 定义上架影片弹出窗口的按钮点击样式
* */
logOffFilm.onclick = function() {     //窗口退出
    filmAdd.style.display = "none";
}


/*
* 修改影片信息
* */
var reviseFilm = document.getElementById("revise-film");
var reviseFilmName = document.getElementById("revise-film-name");
var operationTypeFilm = document.getElementById("operation-type-film");
var confirmReviseFilm = document.getElementById("confirm-revise-film");
var filmLogOff = document.getElementById("film-log-off");
var filmRevise = document.getElementById("film-revise");
var reviseFilmContent = document.getElementById("revise-film-content");
var imgContent = document.getElementById('img-content');
var formAction = document.getElementById("form-action");

addFilm.onclick = function() {       //弹出上传影片窗口
	formAction.action = "film_insert_servlet";
    operationTypeFilm.innerHTML = "上架影片";
    filmAdd.style.display = "block";
    filmRevise.style.display = "none";
    filmConfirm.style.display = "block";
}

reviseFilm.onclick = function() {     //点击修改影片按钮
    reviseFilmName.style.display = "block";
}

/*
 * 根据影片名获取影片信息
 * */
confirmReviseFilm.onclick = function() {    //点击修改确认按钮
    reviseFilmName.style.display = "none";
    formAction.action = "film_update_servlet";
    var reviseFilmXhr = new XMLHttpRequest();
    reviseFilmXhr.open("POST","http://localhost:8080/TTMS/film_update_edit_servlet",true);
    reviseFilmXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    reviseFilmXhr.send("name="+reviseFilmContent.value);
    reviseFilmXhr.onreadystatechange = function() {
		if(reviseFilmXhr.readyState === 4 && reviseFilmXhr.status === 200) {
			
			if(reviseFilmXhr.responseText === "no-ok"){
				turnOff.innerHTML = "该影片不存在！";
				turnOff.style.opacity = 1;
				setTimeout(function(){
					turnOff.style.opacity = 0;
				},2000);
				
			} else {
				var strMovie = JSON.parse(reviseFilmXhr.responseText);
				//console.log(reviseFilmXhr.responseText);
				operationTypeFilm.innerHTML = "修改影片";
			    filmConfirm.style.display = "none";
			    filmRevise.style.display = "block";
			    filmAdd.style.display = "block";
			    
			    directorFilm.value = strMovie.director;
                typeFilm.value = strMovie.type;
                areaFilm.value = strMovie.region;
                languageFilm.value = strMovie.language;
                sheetLengthFilm.value = strMovie.time;
                actorFilm.value = strMovie.performer;
                nameFilm.value = strMovie.name;
                dataURL = strMovie.url;
                imgContent.innerHTML = '<img src="data:image/jpg;base64,'+strMovie.url + '" />';
			}
		}
	} 
}


filmLogOff.onclick = function() {        //点击退出按钮
    reviseFilmName.style.display = "none";
}

/*
 * 删除影片
 * */
var deleteFilm = document.getElementById("delete-film");
var deleteFilmName = document.getElementById("delete-film-name");
var confirmDeleteFilm = document.getElementById("confirm-delete-film");
var deleteFilmContent = document.getElementById("delete-film-content");
var deleteFilmLogOff = document.getElementById("delete-film-log-off");

deleteFilm.onclick = function() {     //点击删除影片按钮
    deleteFilmName.style.display = "block";
    
}
confirmDeleteFilm.onclick = function() {    //点击删除确认按钮

	deleteFilmName.style.display = "none";
	
	var deleteFilmXhr = new XMLHttpRequest();
	deleteFilmXhr.open("POST","http://localhost:8080/TTMS/film_delete_servlet",true);
	deleteFilmXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	deleteFilmXhr.send("name="+deleteFilmContent.value);
	deleteFilmXhr.onreadystatechange = function() {
		if(deleteFilmXhr.readyState === 4 && deleteFilmXhr.status === 200) {
			if(deleteFilmXhr.responseText === "ok") {
				turnOff.innerHTML = "影片删除成功！";
			} else {
				turnOff.innerHTML = "影片删除失败！";
			}		
		}
	}
	turnOff.style.opacity = 1;
    setTimeout(function(){
        turnOff.style.opacity = 0;
    },2000);
	
}

deleteFilmLogOff.onclick = function() {        //点击退出按钮
    deleteFilmName.style.display = "none";
}