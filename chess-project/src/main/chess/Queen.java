package chess;


public class Queen extends Piece{
	private PieceColour colour;
	private String symbol;

	public Queen(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♕";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♛";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	private int abs(int n){
		if(n < 0) return -n;
		else return n;
	}

	private boolean isBlock(int i0, int j0, int i1, int j1){
		//top right
		if((j1-j0)>0 && (i1-i0)<0){
			for(int i=1;i<(j1-j0);++i){
				if(Board.hasPiece(i0-i,j0+i)){
					return true;
				}
			}
			return false;
		}
		//right
		else if(j1>j0 && i1==i0){
			for(int i=1;i<(j1-j0);++i){
				if(Board.hasPiece(i0,j0+i)){
					return true;
				}
			}
			return false;
		}
		//bottom right
		else if(j1>j0 && i1>i0){
			for(int i=1;i<(j1-j0);++i){
				if(Board.hasPiece(i0+i,j0+i)){
					return true;
				}
			}
			return false;
		}
		//down
		else if(j1==j0 && i1>i0){
			for(int i=1;i<(i1-i0);++i){
				if(Board.hasPiece(i0+i,j0)){
					return true;
				}
			}
			return false;
		}
		//bottom left;
		else if(j1<j0 && i1>i0){
			for(int i=1;i<(i1-i0);++i){
				if(Board.hasPiece(i0+i,j0-i)){
					return true;
				}
			}
			return false;
		}
		//left;
		else if(j1<j0 && i1==i0){
			for(int i=1;i<(j0-j1);++i){
				if(Board.hasPiece(i0,j0-i)){
					return true;
				}
			}
			return false;
		}
		//top left;
		else if(j1<j0 && i1<i0){
			for(int i=1;i<(i0-i1);++i){
				if(Board.hasPiece(i0-i,j0-i)){
					return true;
				}
			}
			return false;
		}
		//top;
		else if(i1<i0&&j1==j0){
			for(int i=1;i<(i0-i1);++i){
				if(Board.hasPiece(i0-i,j0)){
					return true;
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if(
		((i1 == i0) && (j1 != j0)) |
		((i1 != i0) && (j1 == j0)) |
		(this.abs(j1-j0) == this.abs(i1-i0))
		){
			//check is not blocked
			if(this.isBlock(i0,j0,i1,j1)) return false;
			// if is empty, legit.
			if(!Board.hasPiece(i1,j1)) return true;
			// not empty, check if the piece can eat it.
			else if(this.colour != Board.getPiece(i1,j1).getColour()) return true;
		}
		return false;
	}
}
