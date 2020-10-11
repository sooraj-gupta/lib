#include <iostream>

class SoorajArrayTools {
public:
    template < typename T >
    static void printArray( T arr[], int size ){
        for (int i = 0; i < size; i++ ){
            std::cout << arr[i];
            if( i != size - 1){
                std::cout << ", ";
            }
            else
            {
                std::cout << std::endl;
            }
        }
    }
    
    
};