package chess;


public class Pawn extends Piece{
	protected PieceColour colour;
	private String symbol;

	public Pawn(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♙";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♟";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	private boolean isBlock(int i0, int j0, int i1, int j1){
		//down
		if(j1==j0 && i1>i0){
			//check if lock
			/*
			if(
			(i0+1<7&&j0+1<7&&Board.getPiece(i0+1,j0+1).getSymbol().equals("♙")) |
			(i0+1<7&&j0-1>0&&Board.getPiece(i0+1,j0-1).getSymbol().equals("♙"))
			) return false;
			*/
			for(int i=1;i<(i1-i0);++i){
				if(
				Board.hasPiece(i0+i,j0)
				/*
				|(i0+i+1<=7&&j0+1<=7&&Board.hasPiece(i0+i+1,j0+1))|
				(i0+i+1<=7&&j0-1>=0&&Board.hasPiece(i0+i+1,j0-1))*/
				){
					return true;
				}
			}
			return false;
		}
		//top;
		else if(i1<i0&&j1==j0){
			//check if lock
			/*
			if(
			(i0-1>0&&j0+1<7&&Board.getPiece(i0-1,j0+1).getSymbol().equals("♟")) |
			(i0-1>0&&j0-1>0&&Board.getPiece(i0-1,j0-1).getSymbol().equals("♟"))
			) return false;
			*/
			for(int i=1;i<(i0-i1);++i){
				if(Board.hasPiece(i0-i,j0)
				/*
				|(i0-i-1>=0&&j0+1<=7&&Board.hasPiece(i0-i-1,j0+1))|
				(i0-i-1>=0&&j0-1>=0&&Board.hasPiece(i0-i-1,j0-1))
				*/
				){
					return true;
				}
			}
			return false;
		}
		return true;
	}

	private boolean checkWithD(int i0, int j0, int i1, int j1, int direction){
		if(j1==j0 && (i1==i0-1*direction | i1==i0-2*direction)){
			if(i1==i0-2*direction){
				if((direction == 1 && i0 == 6) | (direction == -1 && i0 == 1)) return true;
				return false;
			}
			//check is not blocked
			if(this.isBlock(i0,j0,i1,j1)) return false;
			//empty, legit
			if(!Board.hasPiece(i1,j1)) {
				return true;
			}
		}else if(i1==i0-1*direction && (j1==j0-1|j1==j0+1)){
			if(Board.hasPiece(i1,j1) && Board.getPiece(i1,j1).getColour()!=this.colour) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if(i0 == i1 && j0 == j1) return false;
		// for white , 1
		if(this.colour == PieceColour.WHITE){
			return this.checkWithD(i0,j0,i1,j1,1);
		}else{
			return this.checkWithD(i0,j0,i1,j1,-1);
		}
	}
}
