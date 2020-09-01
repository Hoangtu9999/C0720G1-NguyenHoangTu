/**
 * Created by nhatnk on 4/26/17.
 */

function Hero(image, top, left, size){
  this.image = image;
  this.top = top;
  this.left = left;
  this.size = size;

  this.getHeroElement = function(){
    return '<img width="'+ this.size + '"' +
      ' height="'+ this.size + '"' +
      ' src="' + this.image +'"' +
      ' style="top: '+this.top+'px; left:'+this.left+'px;position:absolute;" />';
  }

  this.moveRight = function(){
    this.left += 50;
    console.log('ok: ' + this.left);
  }

   this.moveTop = function(){
    this.top += 20;
    console.log('ok: ' + this.top);
  }

}

var hero = new Hero('89268741_2601633653403718_5074001915986051072_n.jpg', 20, 30, 200);
hero.speed

function start(){
  if(hero.left < window.innerWidth - hero.size){
    hero.moveRight();
  }
  if(hero.top < window.innerHeight - hero.size){
	hero.moveTop();
  }

  document.getElementById('game').innerHTML = hero.getHeroElement();
  setTimeout(start, 500)
}

start();