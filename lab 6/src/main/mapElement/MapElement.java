package main.mapElement;

import main.utility.Position;


public abstract class MapElement {
        protected Position pos= new Position(0,0);
        MapElement(Position position){this.pos=position;}
        public Position getPosition(){return this.pos;}
        @Override
        public abstract String toString();
}
