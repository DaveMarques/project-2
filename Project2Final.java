float redX,redY,redDX,redDY;
float bluX,bluY,bluDX,bluDY;
float yelX,yelY,yelDX,yelDY;
float tableTop,tableBottom,tableRight,tableLeft;
float ballDia;
float tmp;
float buttonX,buttonY,buttonDia;


void setup(){
  size(600,400);
  reset();
}

//reset Function
void reset(){
  rectMode(CORNERS);
  
  //table dimensions
  tableTop = height/3;
  tableBottom = height-30;
  tableRight = width - 30;
  tableLeft = 30;
  
  //resetting balls to random positions on right side of table
  redX = random(width/2,tableRight);
  bluX = random(width/2,tableRight);
  yelX = random(width/2,tableRight);
  
  //reseting balls to random positions between the pool table
  redY = random(tableTop,tableBottom);
  bluY = random(tableTop,tableBottom);
  yelY = random(tableTop,tableBottom);
  
  //random speeds
  redDX = random(-2,2);
  redDY = random(-2,2);
  yelDX = random(-2,2);
  yelDY = random(-2,2);
  bluDX = random(-2,2);
  bluDY = random(-2,2);
  
  ballDia = 40;
  
  buttonX = width/2;
  buttonY = height/8;
  buttonDia = 30;
  
}

void draw(){
  scene();
  balls();
  ballMovement();
  tableCollisions();
  ballCollisions();
  
}

void scene(){
  //Pool table and button
  background(#D1E53A);
  fill(0,255,0);
  rect(tableLeft-(ballDia/2),tableTop-(ballDia/2),tableRight+(ballDia/2),tableBottom+(ballDia/2));
  
  //button
  fill(255);
  ellipse(buttonX,buttonY,buttonDia,buttonDia);
  fill(0);
  text("Reset",buttonX - 15,buttonY - 20);
  
  text("Made by David Marques",10,10);
  
}

void balls(){
  //displaying balls and numbers
  fill(255,0,0);
  ellipse(redX,redY,ballDia,ballDia);
  
  
  fill(255,255,0);
  ellipse(yelX,yelY,ballDia,ballDia);
  
  
  fill(0,0,255);
  ellipse(bluX,bluY,ballDia,ballDia);
  
  fill(0);
  text('1',redX,redY);
  text('2',yelX,yelY);
  text('3',bluX,bluY);
  
}

void ballMovement(){
  //movement of the balls
  redX += redDX;
  redY += redDY;
  yelX += yelDX;
  yelY += yelDY;
  bluX += bluDX;
  bluY += bluDY;
  
}

void tableCollisions(){
  //ball Collisions with the table
  if (redX < tableLeft || redX > tableRight) redDX *= -1;
  if (redY < tableTop || redY > tableBottom) redDY *= -1;
  if (yelX < tableLeft || yelX > tableRight) yelDX *= -1;
  if (yelY < tableTop || yelY > tableBottom) yelDY *= -1;
  if (bluX < tableLeft || bluX > tableRight) bluDX *= -1;
  if (bluY < tableTop || bluY > tableBottom) bluDY *= -1;
  
}

void ballCollisions(){
  //swaping DXs and DYs if balls collide
  if(dist(redX,redY,yelX,yelY) < ballDia){
    tmp = redDX; redDX = yelDX; yelDX = tmp;
    tmp = redDY; redDY = yelDY; yelDY = tmp;
  }
  if(dist(redX,redY,bluX,bluY) < ballDia){
    tmp = redDX; redDX = bluDX; bluDX = tmp;
    tmp = redDY; redDY = bluDY; bluDY = tmp;
  }
   if(dist(bluX,bluY,yelX,yelY) < ballDia){
    tmp = bluDX; bluDX = yelDX; yelDX = tmp;
    tmp = bluDY; bluDY = yelDY; yelDY = tmp;
  }
}

void mousePressed(){
  //button press makes reset(); run
  if(dist(mouseX,mouseY,buttonX,buttonY) < (buttonDia/2)) reset();
}








