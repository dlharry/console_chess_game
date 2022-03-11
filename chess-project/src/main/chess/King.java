package chess;


public class King extends Piece{
	private PieceColour colour;
	private String symbol;

	public King(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♔";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♚";
		}
	}
	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if(((i1 == i0+1 | i1 == i0-1) && (j1 == j0+1 | j1 == j0-1))|
		(i1 == i0 && (j1 == j0+1 | j1 == j0-1))|
		(j1 == j0 && (i1 == i0+1 | i1 == i0-1))
		){
			if(!Board.hasPiece(i1,j1)) return true;
			else if(this.colour == PieceColour.WHITE){
				if(Board.getPiece(i1,j1).getColour() == PieceColour.BLACK) return true;
				return false;
			}
			else if(this.colour == PieceColour.BLACK){
				if(Board.getPiece(i1,j1).getColour() == PieceColour.WHITE) return true;
				return false;
			}
		}
		return false;
	}
}
