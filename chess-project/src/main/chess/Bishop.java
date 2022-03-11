package chess;


public class Bishop extends Piece{
	private PieceColour colour;
	private String symbol;

	public Bishop(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♗";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♝";
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

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		boolean flag = false;
		if( i1-i0 == j1-j0 && i1-i0>0 ){
			flag = false;
			for(int i=1;i<i1-i0;++i){
				if(Board.hasPiece(i0+i,j0+i)){
					flag = true;
					break;
				}
			}
			if(flag == false){
				if(!Board.hasPiece(i1,j1)) return true;
				else if(Board.getPiece(i1,j1).getColour() != this.colour) return true;
				else return false;
			}
		}
		else if( i1-i0 == j1-j0 && i1-i0<0 ){
			flag = false;
			for(int i=-1;i>i1-i0;--i){
				if(Board.hasPiece(i0+i,j0+i)){
					flag = true;
					break;
				}
			}
			if(flag == false){
				if(!Board.hasPiece(i1,j1)) return true;
				else if(Board.getPiece(i1,j1).getColour() != this.colour) return true;
				else return false;
			}
		}
		else if( i1-i0 == j0-j1 && i1-i0>0 ){
			flag = false;
			for(int i=1;i<i1-i0;++i){
				if(Board.hasPiece(i0+i,j0-i)){
					flag = true;
					break;
				}
			}
			if(flag == false){
				if(!Board.hasPiece(i1,j1)) return true;
				else if(Board.getPiece(i1,j1).getColour() != this.colour) return true;
				else return false;
			}
		}
		else if( i1-i0 == j0-j1 && i1-i0<0 ){
			flag = false;
			for(int i=-1;i>i1-i0;--i){
				if(Board.hasPiece(i0+i,j0-i)){
					flag = true;
					break;
				}
			}
			if(flag == false){
				if(!Board.hasPiece(i1,j1)) return true;
				else if(Board.getPiece(i1,j1).getColour() != this.colour) return true;
				else return false;
			}
		}
		return false;
	}

}
