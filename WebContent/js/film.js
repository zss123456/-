/*
* 改变点击按钮样式
* */
var filmType = document.getElementById("film-type");
var oLi = filmType.getElementsByTagName("li");
var num = 0;
for(var i = 0,len = oLi.length;i < len;i++) {
    oLi[i].index = i;
    oLi[i].onclick = function() {
        oLi[num].style.backgroundColor = "silver";
        num = this.index;
        oLi[num].style.backgroundColor = "orangered";
    }
}


/*var datalist = [
    {
        pictureFilm: "02.jpg",
        director: "李言",
        actor: "叶磊峰,冯麒麟,张蒙蒙,赵东方",
        typeFilm: "喜剧,灵异",
        areaFilm: "中国大陆",
        languageFilm: "普通话",
        sheetLength: "120分钟"
    },{
        pictureFilm: "04.jpg",
        director: "AS ",
        actor: "叶磊峰,冯麒麟,张蒙蒙,赵东方",
        typeFilm: "喜剧,灵异",
        areaFilm: "中国大SD ",
        languageFilm: "普通话",
        sheetLength: "140分钟"
    }
];*/

var data = [{
    pictureFilm: "02.jpg",
    director: "李言",
    actor: "赵松松,叶磊峰,冯麒麟,张蒙蒙,赵东方",
    typeFilm: "喜剧,动作",
    areaFilm: "中国大陆",
    languageFilm: "粤语",
    sheetLength: "140分钟"
},{
    pictureFilm: "02.jpg",
    director: "ASDF",
    actor: "叶磊峰,冯麒麟,张蒙蒙,赵东方",
    typeFilm: "喜剧,灵异",
    areaFilm: "中国大陆",
    languageFilm: "普通话",
    sheetLength: "150分钟"
  }
] ;



/*
 * 获取影片信息
 * */


/*
* 控制影片信息显示动画
* */




/*
* 上架影片
* */
