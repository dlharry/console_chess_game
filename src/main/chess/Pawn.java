package chess;


class Pawn extends Piece{
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

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if(i0 == i1 && j0 == j1) return false;
		if(this.colour == PieceColour.WHITE){
			// no turning back
			if(i1 >= i0) return false;
			if(j1 == j0){
				// no piece at front
				if(i1 == i0 - 1){
					if(Board.hasPiece(i1,j1)){
							return false;
					}
					return true;
				}
				// no piece between and at the front
				else if(i1 == i0 - 2){
					if(Board.hasPiece(i1,j1) | Board.hasPiece(i0-1,j1)){
						return false;
					}
					return true;
				}
				return false;
			}
			// have enemy piece at the diagnol
			if((j1 == j0+1 && i1 == i0-1) | (j1 == j0-1 && i1 == i0-1)){
				if(Board.hasPiece(i1,j1)){
					return true;
				}
				return false;
			}
			return false;
		}
		else if(this.colour == PieceColour.BLACK){
			// no turning back
			if(i1 <= i0) return false;
			if(j1 == j0){
				// no piece at front
				if(i1 == i0 + 1){
					if(Board.hasPiece(i1,j1)){
							return false;
					}
					return true;
				}
				// no piece between and at the front
				else if(i1 == i0 + 2){
					if(Board.hasPiece(i1,j1) | Board.hasPiece(i0+1,j1)){
						return false;
					}
					return true;
				}
				return false;
			}
			// have enemy piece at the diagnol
			if((j1 == j0+1 && i1 == i0+1) | (j1 == j0-1 && i1 == i0+1)){
				if(Board.hasPiece(i1,j1)){
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}
