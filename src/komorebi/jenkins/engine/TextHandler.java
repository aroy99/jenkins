package komorebi.jenkins.engine;


public class TextHandler {
	
	int topY, leftX;
	int texX, texY; //coordinates of top left corner on texture

	char[] chars;
	
	final int HORIZ_SCALE = 6;
	final int VERT_SCALE = 9;
	
	final int HORIZ_BUFFER = 32;
	
	final int TILE_SIZE = 16;
	
	final int DIALOGUE_TOP = 90;
	final int DIALOGUE_LEFT = 9;
	
	int index = 0;
	
	public TextHandler(int topLeftCornerX, int topLeftCornerY) {
		topY = topLeftCornerY;
		leftX = topLeftCornerX;
		
	}
	
	public void write(String s) {
		
		chars = s.toCharArray();
		
	}
	
	public void render() {
	    
	    int row = 0;
	    int column = 0;
	    	    
	    Draw.drawRect(0,0, 272, 96, 0, 160, 272, 256, 0);
		for (int i=0; i<index; i++) {
						
			if (chars[i]=='/') {
				row++;
				column = 0;
			} else {
				int texX = getTexX(chars[i]);
				int texY = getTexY(chars[i]);
				
				int x = DIALOGUE_LEFT + HORIZ_SCALE * column + column++;
				int y = DIALOGUE_TOP - row * TILE_SIZE;
				
				Draw.drawRect(x, y-12, HORIZ_SCALE, VERT_SCALE, texX, texY, texX+HORIZ_SCALE, texY+VERT_SCALE, 0);
			}
		}
		
		if(index<chars.length)index++;
	}
	
	public int getTexX(char s) {
		int texX = 0;
		
		switch (s) {
		case 'A':case 'N':case '.':
			texX = leftX + HORIZ_SCALE*0;
			break;
		case 'B':case 'O':case '!':
			texX = leftX + HORIZ_SCALE * 1;
			break;
		case 'C':case 'P':case '?':
			texX = leftX + HORIZ_SCALE * 2;
			break;
		case 'D':case 'Q':case '1':
			texX = leftX + HORIZ_SCALE * 3;
			break;
		case 'E':case 'R':case '2':
			texX = leftX + HORIZ_SCALE * 4;
			break;
		case 'F':case 'S':case '3':
			texX = leftX + HORIZ_SCALE * 5;
			break;
		case 'G':case 'T':case '4':
			texX = leftX + HORIZ_SCALE * 6;
			break;
		case 'H':case 'U':case '5':
			texX = leftX + HORIZ_SCALE * 7;
			break;
		case 'I':case 'V':case '6':
			texX = leftX + HORIZ_SCALE * 8;
			break;
		case 'J':case 'W':case '7':
			texX = leftX + HORIZ_SCALE * 9;
			break;
		case 'K':case 'X':case '8':
			texX = leftX + HORIZ_SCALE * 10;
			break;
		case 'L':case 'Y':case '9':
			texX = leftX + HORIZ_SCALE * 11;
			break;
		case 'M':case 'Z':case '0':
			texX = leftX + HORIZ_SCALE * 12;
			break;
		default:
			texX = leftX + HORIZ_SCALE * 13;
			break;
		}
		
		return texX;
	}
	
	public int getTexY(char s) {
		
		int texY = 0;
		
		switch (s) {
		case 'A':case 'B':case 'C':case 'D':case 'E':case 'F':
		case 'G':case 'H':case 'I':case 'J':case 'K':case 'L':case 'M':
			texY = topY + VERT_SCALE*0;
			break;
		case 'N':case 'O':case 'P':case 'Q':case 'R':case 'S':
		case 'T':case 'U':case 'V':case 'W':case 'X':case 'Y':case 'Z':
			texY = topY + VERT_SCALE*1;
			break;
		case '.':case '!':case '?':case '1':case '2':case '3':
		case '4':case '5':case '6':case '7':case '8':case '9':case '0':
			texY = topY + VERT_SCALE*2;
			break;
		default:
			texY = topY + VERT_SCALE * 0;
		}
		
		return texY;
	}
	
}
