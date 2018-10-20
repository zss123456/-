/*
*   添加演出厅
* */
var getMovieList = document.getElementById("movie-list");
var addHall = document.getElementById("add-hall");
var add =  document.getElementById("movie-hall-add");
var logOff = document.getElementById("log-off");
var btnContent = add.getElementsByClassName("btn-content")[0];
addHall.onclick = function() {
    add.style.display = "block";
	btnSubmit.style.display = "block";
    operationType.innerHTML = "添加演出厅";
    btnReset.style.display = "block";
    btnRevise.style.display = "none";
    btnContent.style.paddingLeft = 140+"px";
    
    hallSeats.value = "";
	hallName.value = "";
	hallRows.value = "";
	hallColumn.value = "";
	hallDescription.value = "";
}
logOff.onclick = function() {
    add.style.display = "none";
}

/*
 * 弹出式窗口
 * */

var turnOff = document.getElementById("turn-off");


/*
*   删除演出厅
* */
var deleteLogOff = document.getElementById("delete-log-off");
var deleteHall = document.getElementById("delete-hall");
var movieHallDelete = document.getElementById("movie-hall-delete");

deleteHall.onclick = function() {
    movieHallDelete.style.display = "block";
}
deleteLogOff.onclick = function() {
    movieHallDelete.style.display = "none";
}

var deleteContentId = document.getElementById("delete-content-id");
var deleteStart = document.getElementById("delete-start");
deleteStart.onclick = function() {
	   var deleteXhr = new XMLHttpRequest();
	   deleteXhr.open("POST","http://localhost:8080/TTMS/theatre_delete_servlet",true);
	   deleteXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	   deleteXhr.send("id="+deleteContentId.value);
	   deleteXhr.onreadystatechange = function() {
	         if(deleteXhr.status == 200 && deleteXhr.readyState == 4) {
	        	 	var str = deleteXhr.responseText;
	        	 	if(str === "ok") {
	        	    	 turnOff.innerHTML = "演出厅删除成功！";
	        	     } else {
	        	    	 turnOff.innerHTML = "演出厅删除失败！";
	        	     }
	         }
	     }
	   movieHallDelete.style.display = "none";
	     turnOff.style.opacity = 0.9;
	     setTimeout(function() {
	    	 turnOff.style.opacity = 0;
	     },2000);
	}

/*
 * 添加演出厅
 * */
var hallName = document.getElementById("hall-name");
var hallRows = document.getElementById("hall-rows");
var hallColumn = document.getElementById("hall-column");
var hallSeats = document.getElementById("hall-seats");
var hallDescription = document.getElementById("hall-description");
var btnSubmit = document.getElementById("btn-submit");

btnSubmit.onclick = function() {
	
   var addXhr = new XMLHttpRequest();
     addXhr.open("POST","http://localhost:8080/TTMS/theatre_insert_servlet",true);
     addXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
     addXhr.send("id="+hallSeats.value+"&name="+hallName.value+"&rows="+hallRows.value+"&cols="+hallColumn.value+"&desc="+hallDescription.value);
     addXhr.onreadystatechange = function() {
         if(addXhr.status == 200 && addXhr.readyState == 4) {
        	 	var str = addXhr.responseText;
        	 	if(str === "ok") {
        	    	 turnOff.innerHTML = "演出厅添加成功！";
        	    	 hallSeats.value = "";
        	    	 hallName.value = "";
        	    	 hallRows.value = "";
        	    	 hallColumn.value = "";
        	    	 hallDescription.value = "";
        	     } else {
        	    	 turnOff.innerHTML = "演出厅添加失败！";
        	     }
         }
     }
     add.style.display = "none";
     turnOff.style.opacity = 0.9;
     setTimeout(function() {
    	 turnOff.style.opacity = 0;
     },2000);
}

/*
 * 修改演出厅
 * */
var reviseMovieHall = document.getElementById("movie-hall-revise");
var confirmRevise = document.getElementById("confirm-revise");
var reviseLogOff = document.getElementById("revise-log-off");
var reviseHall = document.getElementById("revise-hall");
var operationType = document.getElementById("operation-type");
var btnReset = document.getElementById("btn-reset");
var reviseContent = document.getElementById("revise-content");
var oUl = document.getElementById("movieHall-list");
var btnRevise = document.getElementById("btn-revise");


reviseHall.onclick = function() {
	reviseContent.value = "";
    reviseMovieHall.style.display = "block";
}
reviseLogOff.onclick = function() {
    reviseMovieHall.style.display = "none";
}

/*
 * 根据演出厅ID获取演出厅信息
 * */
confirmRevise.onclick = function() {
	reviseMovieHall.style.display = "none";
	
	var reviseXhr = new XMLHttpRequest();
	reviseXhr.open("POST","http://localhost:8080/TTMS/theatre_update_servlet_edit",true);
	reviseXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	reviseXhr.send("id="+reviseContent.value);
	reviseXhr.onreadystatechange = function() {
		if(reviseXhr.readyState === 4 && reviseXhr.status === 200) {
			
			if(reviseXhr.responseText === "no-ok"){
				turnOff.innerHTML = "该演出厅不存在！";
				turnOff.style.opacity = 1;
				setTimeout(function(){
					turnOff.style.opacity = 0;
				},2000);
			} else {
				var strMovie = JSON.parse(reviseXhr.responseText);
				operationType.innerHTML = "修改演出厅";
				add.style.display = "block";
				btnRevise.style.display = "block";
				btnReset.style.display = "block";
				btnSubmit.style.display = "none";
				btnContent.style.paddingLeft = 200+"px";
				hallSeats.value = strMovie.id;
   	    	 	hallName.value = strMovie.name;
   	    	 	hallRows.value = strMovie.rows;
   	    	 	hallColumn.value = strMovie.cols;
   	    	 	hallDescription.value = strMovie.desc;
			}
		}
	}
}

/*
 * 提交修改后的演出厅信息
 * */
btnRevise.onclick = function() {
	
	var reviseContentXhr = new XMLHttpRequest();
	reviseContentXhr.open("POST","http://localhost:8080/TTMS/theatre_update_servlet",true);
	reviseContentXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	reviseContentXhr.send("id="+hallSeats.value+"&name="+hallName.value+"&rows="+hallRows.value+"&cols="+hallColumn.value+"&desc="+hallDescription.value);
	reviseContentXhr.onreadystatechange = function() {
		if(reviseContentXhr.readyState === 4 && reviseContentXhr.status === 200) {
			
			console.log(reviseContentXhr.responseText);
			if(reviseContentXhr.responseText === "ok"){
				turnOff.innerHTML = "演出厅修改成功！";
				
			} else {
				turnOff.innerHTML = "该演出厅不存在！";
				
			}
		}
	}
	add.style.display = "none";
	turnOff.style.opacity = 1;
	setTimeout(function(){
		turnOff.style.opacity = 0;
	},2000);
}
//reviseXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    

