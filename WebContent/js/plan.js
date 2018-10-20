/**
 * 
 */
var planAdd = document.getElementById("plan-add");
var logOffPlan = document.getElementById("log-off-plan");
            var addPlan = document.getElementById("add-plan");
            var performancePlanDelete = document.getElementById("performance-plan-delete");
            var deletePlan = document.getElementById("delete-plan");
            var addStartTime = document.getElementById("add-start-time");
            var addEndTime = document.getElementById("add-end-time");
            var planConfirm = document.getElementById("plan-confirm");
            var optionTime = addStartTime.getElementsByTagName("option");
            var addFilmTime = document.getElementById("add-film-time");
            var addFilmName = document.getElementById("add-film-name");
            var turnOff = document.getElementById("turn-off");
            var logDeleteOff = document.getElementById("log-delete-plan");
            var addMovieName = document.getElementById("add-movie-name");
            var deleteMovieName = document.getElementById("delete-movie-name")
            var deletePlanConfirm = document.getElementById("delete-plan-confirm");
            var deleteStartTime = document.getElementById("delete-start-time");
            
            var planOperationType = document.getElementById("plan-operation-type");
            var revisePlanConfirm = document.getElementById("revise-plan-confirm");
            var revisePlan = document.getElementById("revise-plan");
         
            var planRevise = document.getElementById("plan-revise");
            var logRevisePlan = document.getElementById("log-revise-plan");
            var reviseMovieName = document.getElementById("reviae-movie-name");
            var revisePlanFilm = document.getElementById("revise-plan-film");
            var reviseStartTime = document.getElementById("revise-start-time");
            var reviseFilmTime = document.getElementById("revise-film-time");
            var reviseEndTime = document.getElementById("revise-end-time");
            var planReviseConfirm = document.getElementById("plan-revise-confirm");
            
            var time = [];
            var times = [];
            var firstTime = 0;
            var valueTime = 0;
            
            var reviseFirstTime = 0,reviseValueTime = 0;
            
            var filmInformation,movieInformation;

            function stringChangeNumber(string) {
                return Number(string);
            }
            function computingTime(number,valueTime) {
                var hour,minute;
                hour = (number+Math.floor(stringChangeNumber(valueTime)/60)) > 24 ?
                    (number+Math.floor(stringChangeNumber(valueTime)/60))%24 :
                    (number+Math.floor(stringChangeNumber(valueTime)/60));
                minute = stringChangeNumber(valueTime)%60;
               if(hour < 10) {
                   hour = "0"+hour;
               }
               if(minute < 10) {
                   minute = "0"+minute;
               }
                return hour+":"+minute;
            }
            addStartTime.onchange = function() {
                addEndTime.value = computingTime(stringChangeNumber(addStartTime.value),valueTime);
            }
            addFilmName.onchange = function() {
            	valueTime = stringChangeNumber(time[this.selectedIndex]);
            	addFilmTime.value = stringChangeNumber(time[this.selectedIndex])+"分钟";
            	addEndTime.value = computingTime(stringChangeNumber(addStartTime.value),valueTime);
            }
            
            reviseStartTime.onchange = function() {
            	reviseEndTime.value = computingTime(stringChangeNumber(reviseStartTime.value),reviseValueTime);
            }
            revisePlanFilm.onchange = function() {
            	reviseValueTime = stringChangeNumber(times[this.selectedIndex]);
            	reviseFilmTime.value = stringChangeNumber(times[this.selectedIndex])+"分钟";
            	reviseEndTime.value = computingTime(stringChangeNumber(reviseStartTime.value),reviseValueTime);
            }
            
            logOffPlan.onclick = function() {
                planAdd.style.display = "none";
            }
            logDeleteOff.onclick = function() {
            	performancePlanDelete.style.display = "none";
            }
            logRevisePlan.onclick = function() {
            	planRevise.style.display = "none";
            }
            function createPlanMovie(datalist) {
            	addMovieName.innerHTML = "";
            	for(var i = 0,item;item = datalist[i++];) {
            		var option = document.createElement("option");
            		option.value = item.id;
            		option.innerText = "0"+item.id;
            		addMovieName.appendChild(option);
            	}
            }
            function createDeletePlanMovie(datalist) {
            	deleteMovieName.innerHTML = "";
            	for(var i = 0,item;item = datalist[i++];) {
            		var option = document.createElement("option");
            		option.value = item.id;
            		option.innerText = "0"+item.id;
            		deleteMovieName.appendChild(option);
            	}
            	
            }
            function createPlanFilm(datalist) {
            	addFilmName.innerHTML ="";
            	for(var i = 0,item;item = datalist[i];i++) {
            		time[i] = item.time;
            		var option = document.createElement("option");
            		option.value = item.name;
            		option.innerText = item.name;
            		addFilmName.appendChild(option);
            	}
            }
            
            function createRevisePlanMovie(data,datalist) {
            	reviseMovieName.innerHTML = "";
            	var opt = document.createElement("option");
            	opt.value = data.id;
        		opt.innerText = "0"+data.id;
        		reviseMovieName.appendChild(opt);
            	for(var i = 0,item;item = datalist[i++];) {
            		if(item.id === data.id) {
            			continue;
            		}
            		var option = document.createElement("option");
            		option.value = item.id;
            		option.innerText = "0"+item.id;
            		reviseMovieName.appendChild(option);
            	}
            	
            }
            function createRevisePlanFilm(data,datalist) {
            	revisePlanFilm.innerHTML = "";
            	var opt = document.createElement("option");
            	opt.value = data.name;
        		opt.innerText = data.name;
        		revisePlanFilm.appendChild(opt);
        		
            	for(var i = 0,item;item = datalist[i++];) {
            		times[i] = item.time;
            		if(item.name === data.name) {
            			continue;
            		}
            		var option = document.createElement("option");
            		option.value = item.name;
            		option.innerText = item.name;
            		revisePlanFilm.appendChild(option);
            	}
            	
            }
            addPlan.onclick = function() {
                planAdd.style.display = "block";
                var planXhr = new XMLHttpRequest();
                planXhr.open("GET","http://localhost:8080/TTMS/Plan_return_servlet",true);
                planXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                planXhr.send(null);
                planXhr.onreadystatechange = function() {
                	if(planXhr.readyState === 4 && planXhr.status === 200) {
                		var str = (planXhr.responseText).split("#");
                		var filmStr = JSON.parse(str[0]);
                		var movieStr = JSON.parse(str[1]);
                		createPlanMovie(movieStr);
                		createPlanFilm(filmStr);
                		firstTime = stringChangeNumber(time[0]);
                		addFilmTime.value = firstTime+"分钟";
                		valueTime = firstTime;
                		addEndTime.value = computingTime(0,valueTime);
                	}
                }
            }
            
            deletePlan.onclick = function() {
            	planOperationType.innerHTML = "删除演出计划";
            	deletePlanConfirm.style.display = "block";
            	revisePlanConfirm.style.display = "none";
            	performancePlanDelete.style.display = "block";
            	var planDeleteXhr = new XMLHttpRequest();
            	planDeleteXhr.open("GET","http://localhost:8080/TTMS/Plan_return_servlet",true);
            	planDeleteXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            	planDeleteXhr.send(null);
            	planDeleteXhr.onreadystatechange = function() {
                	if(planDeleteXhr.readyState === 4 && planDeleteXhr.status === 200) {
                		var str = (planDeleteXhr.responseText);
                		var str = (planDeleteXhr.responseText).split("#");
                		movieStr = JSON.parse(str[1]);
                		createDeletePlanMovie(movieStr);
                		//console.log(movieStr);
                	}
                }
            }

            revisePlan.onclick = function() {
            	planOperationType.innerHTML = "修改演出计划";
            	deletePlanConfirm.style.display = "none";
            	revisePlanConfirm.style.display = "block";
            	performancePlanDelete.style.display = "block";
            	
            	var planReviseXhr = new XMLHttpRequest();
            	planReviseXhr.open("GET","http://localhost:8080/TTMS/Plan_return_servlet",true);
            	planReviseXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            	planReviseXhr.send(null);
            	planReviseXhr.onreadystatechange = function() {
                	if(planReviseXhr.readyState === 4 && planReviseXhr.status === 200) {
                		var str = (planReviseXhr.responseText);
                		var str = (planReviseXhr.responseText).split("#");
                		filmInformation = JSON.parse(str[0]);
                		movieInformation = JSON.parse(str[1]);
                		var movieStr = JSON.parse(str[1]);
                		createDeletePlanMovie(movieStr);
                		//console.log(movieStr);
                	}
                }
            }
/*
 * 添加演出计划
 * 
 */
            planConfirm.onclick = function() {
                planAdd.style.display = "none";
                var addPlanXhr = new XMLHttpRequest();
                addPlanXhr.open("POST","http://localhost:8080/TTMS/plan_insert_servlet",true);
                addPlanXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");;
                addPlanXhr.send("name="+addFilmName.value+"&id="+addMovieName.value+"&start="+addStartTime.value+":00"
                		+"&end="+addEndTime.value+"&time="+valueTime);
                addPlanXhr.onreadystatechange = function() {
                    if(addPlanXhr.readyState === 4 && addPlanXhr.status === 200) {
                        if(addPlanXhr.responseText === "ok") {
                        	turnOff.innerHTML = "添加演出计划成功！";
                        } else if(addPlanXhr.responseText === "nok"){
                        	turnOff.innerHTML = "该演出计划已存在！";
                        }else{
                        	turnOff.innerHTML = "添加演出计划失败！";
                        }
                    }
                }
                turnOff.style.opacity = 1;
                setTimeout(function(){
                    turnOff.style.opacity = 0;
                },2000);
            }
            
            
/*
 * 删除演出计划
 * 
 */
            deletePlanConfirm.onclick = function() {
            	performancePlanDelete.style.display = "none";
                var deletePlanXhr = new XMLHttpRequest();
                deletePlanXhr.open("POST","http://localhost:8080/TTMS/plan_delete_servlet",true);
                deletePlanXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");;
                deletePlanXhr.send("id="+deleteMovieName.value+"&start="+deleteStartTime.value+":00");
                deletePlanXhr.onreadystatechange = function() {
                    if(deletePlanXhr.readyState === 4 && deletePlanXhr.status === 200) {
                        if(deletePlanXhr.responseText === "ok") {
                        	turnOff.innerHTML = "删除演出计划成功！"
                        } else {
                        	turnOff.innerHTML = "删除演出计划失败！"
                        }
                    }
                }
                console.log(deleteMovieName.value,deleteStartTime.value);
                turnOff.style.opacity = 1;
                setTimeout(function(){
                    turnOff.style.opacity = 0;
                },2000);
            }
          
/*
 * 修改演出计划
 * */

            revisePlanConfirm.onclick = function() {
            	performancePlanDelete.style.display = "none";
            	
            	var revisePlanXhr = new XMLHttpRequest();
                revisePlanXhr.open("POST","http://localhost:8080/TTMS/plan_update_edit_servlet",true);
                revisePlanXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");;
                revisePlanXhr.send("id="+deleteMovieName.value+"&start="+deleteStartTime.value+":00");
                revisePlanXhr.onreadystatechange = function() {
                    if(revisePlanXhr.readyState === 4 && revisePlanXhr.status === 200) {
                        
                        if(revisePlanXhr.responseText === "no-ok") {
                        	turnOff.innerHTML = "该演出计划不存在！";
                        } else {
                        	var str = JSON.parse(revisePlanXhr.responseText);
                        	planRevise.style.display = "block";
                        	createRevisePlanMovie(str,movieInformation);
                        	createRevisePlanFilm(str,filmInformation);
                        	
                        	reviseFirstTime = stringChangeNumber(str.time);
                        	reviseFilmTime.value = reviseFirstTime+"分钟";
                    		reviseValueTime = reviseFirstTime;
                    		reviseEndTime.value = computingTime(0,reviseValueTime);
                        }
                        console.log(revisePlanXhr.responseText);
                    }
                }
                console.log(revisePlanXhr.responseText);
                turnOff.style.opacity = 1;
                setTimeout(function(){
                    turnOff.style.opacity = 0;
                },2000);
            }
            
            
            planReviseConfirm.onclick = function() {
            	planRevise.style.display = "none";
                var reviseXhr = new XMLHttpRequest();
                reviseXhr.open("POST","http://localhost:8080/TTMS/plan_update_servlet",true);
                reviseXhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");;
                reviseXhr.send("name="+revisePlanFilm.value+"&id="+reviseMovieName.value+"&start="+reviseStartTime.value+":00"
                		+"&end="+reviseEndTime.value+"&time="+reviseValueTime);
                reviseXhr.onreadystatechange = function() {
                    if(reviseXhr.readyState === 4 && reviseXhr.status === 200) {
                        if(reviseXhr.responseText === "ok") {
                        	turnOff.innerHTML = "修改演出计划成功！";
                        } else if(reviseXhr.responseText === "nok"){
                        	turnOff.innerHTML = "该演出计划已存在！";
                        }else{
                        	turnOff.innerHTML = "修改演出计划失败！";
                        }
                    }
                }
                turnOff.style.opacity = 1;
                setTimeout(function(){
                    turnOff.style.opacity = 0;
                },2000);
            }