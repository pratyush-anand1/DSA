#include <iostream>

using namespace std;

void queenpos(int, int, int);

void getposition()
{
    int n;
    cout << "Enter size of board:" << endl;
    cin >> n;
    int a, b;
    cout << "Enter row position of queen in column 0. Press -1 for empty list:" << endl;
    cin >> a;
    if (a != -1)
    {
        cout << "Enter row position of queen in column 1:" << endl;
        cin >> b;
    }
    if (a != -1)
    {
        cout << "Size of chessboard:" << n << " Your input list: [" << a << "," << b << "]" << endl;
    }
    else
    {
        cout << "Size of chessboard:" << n << " Your input list is empty" << endl;
    }
    if (a != -1)
    {
        queenpos(n, a, b);
    }
    else
    {
        queenpos(n, -1, -1);
    }
}

void queenpos(int n, int a, int b)
{
    cout << "Possible positions of queen in next column:" << endl;
    if (a != -1)
    {
        int i = 0;
        for (int j = 0; j < n; j++)
        {
            if (j != a - 2 && j != b - 1 && j != a && j != b && j != a + 2 && j != b + 1)
            {
                cout << j << endl;
                i++;
            }
            if(i==0){
                printf("Empty list");
                break;
            }
        }
    }
    if(a==-1){
        for(int i=0;i<n;i++){
            cout<<i<<endl;
        }
    }
}

int main()
{
    getposition();
    return 0;
}