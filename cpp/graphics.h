#include <ncurses.h>
#include <string>

class Graphics{
    
public:

    int numColors;
    int width;
    int height;


    Graphics( int useKeypad = 1, bool cursor = false ): numColors(0)
    {
        initscr();
        keypad( stdscr, useKeypad );
        noecho();
        curs_set( cursor );
        cbreak();

        start_color();

        getmaxyx(stdscr, height, width);
    }

    
    bool inScreenLimit( int height_, int width_ ){
        if( height < height_ || width < width_ ){
            return false;
        }
        return true;
    }


    int addColor( int forecolor, int bgcolor ){
        numColors++;
        init_pair( numColors, forecolor, bgcolor );
        return numColors;
    }
    
    void getchWait( int num ){
        timeout(num);
    }

    int chget(){
        return wgetch( stdscr );
    }

    void print( const char* s, int y, int x, int colorNum ){
        attron( COLOR_PAIR( colorNum ) );
        mvprintw ( y, x, s );
        attroff( COLOR_PAIR( colorNum ) );
    }
    void print( int s, int y, int x, int colorNum ){
        attron( COLOR_PAIR( colorNum ) );
        mvprintw ( y, x, std::to_string(s).c_str() );
        attroff( COLOR_PAIR( colorNum ) );
    }
    void print( std::string s, int y, int x, int colorNum ){
        attron( COLOR_PAIR( colorNum ) );
        mvprintw ( y, x, s.c_str() );
        attroff( COLOR_PAIR( colorNum ) );
    }

    void display(bool clearScr = false){
        refresh();
        if( clearScr ) clear();
    }

    int getWidth(){
        return width;
    }

    int getHeight(){
        return height;
    }


    ~Graphics(){
        echo();
        nocbreak();
        refresh();
        endwin();
    }
    
    
};
