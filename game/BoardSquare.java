package game;

import java.util.HashSet;
import java.util.Set;

/**
 * 'Linked Node' representing a square on the board. Stores the
 * name of the room it represents ("hallway" if not a room), the
 * squares that are adjacent to it, and the coordinate(s) of the
 * square (multiple if it is a room typically)
 *
 * @author Badi James
 *
 */
public class BoardSquare {

	private Set<Coordinate> coordinates;
	private Set<BoardSquare> neighbours;
	private String room;
	private boolean isRoom;
	private boolean isVisited = false;

	public BoardSquare(Coordinate coordinate, String room, boolean isRoom){
		this.coordinates = new HashSet<Coordinate>();
		this.coordinates.add(coordinate);
		this.room = room;
		this.isRoom = isRoom;
		this.neighbours = new HashSet<BoardSquare>();
	}

	public BoardSquare(Coordinate coordinate, String room, boolean isRoom,
			BoardSquare... neighbours){
		this.coordinates = new HashSet<Coordinate>();
		this.coordinates.add(coordinate);
		this.room = room;
		this.isRoom = isRoom;
		this.neighbours = new HashSet<BoardSquare>();
		for(int i = 0; i < neighbours.length; i++){
			this.neighbours.add(neighbours[i]);
		}
	}

	public BoardSquare(Coordinate coordinate, String room, boolean isRoom,
			Set<BoardSquare> neighbours){
		this.coordinates = new HashSet<Coordinate>();
		this.coordinates.add(coordinate);
		this.room = room;
		this.isRoom = isRoom;
		this.neighbours = neighbours;
	}

	/**
	 * Adds given boardSquare to the collection of neighbours, then adds
	 * this board square to the given boardSquare's collection of neighbours
	 * @param neighbour
	 */
	public void addNeigbour(BoardSquare neighbour){
		this.neighbours.add(neighbour);
		neighbour.neighbours.add(this);
	}

	public boolean containsCoordinate(Coordinate coord) {
		return this.coordinates.contains(coord);
	}

	public void addCoordinate(Coordinate coord){
		this.coordinates.add(coord);
	}

	public Set<BoardSquare> getNeighbours() {
		return neighbours;
	}

	public String getRoom() {
		return room;
	}

	public Coordinate getACoordinate(){
		return coordinates.iterator().next();
	}

	public boolean isRoom() {
		return isRoom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result + (isRoom ? 1231 : 1237);
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardSquare other = (BoardSquare) obj;
		if (coordinates == null) {
			if (other.coordinates != null)
				return false;
		} else if (!coordinates.equals(other.coordinates))
			return false;
		if (isRoom != other.isRoom)
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}

	/**
	 * Finds the coordinate in the collection of coordinates that is the
	 * closest to the given coordinate
	 * @param from The coordinate to compare to
	 * @return The coordinate in this.coordinates closest to from
	 */
	public Coordinate getClosestCoordinate(Coordinate from) {
		int closest = Integer.MAX_VALUE;
		Coordinate toReturn = null;
		for(Coordinate coord : this.coordinates){
			int distance = (Math.abs(coord.getX() - from.getX()))
				+ (Math.abs(coord.getY() - from.getY()));
			if(distance < closest){
				closest = distance;
				toReturn = coord;
			}
		}
		return toReturn;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}






}
