public enum Direction {
    NORTH(0,1),
    EAST(1,0),
    SOUTH(0,-1),
    WEST(-1,0);

    final int x;
    final int y;

    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Direction turnRight(){
        return values()[(ordinal() + 1)% values().length];
    }

    public Direction turnLeft(){
        return values()[(ordinal() + 3) % values().length];
    }
}
