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
    char arr[100][100];
    int pos[100];
    cout << "Possible positions of queen in next column:" << endl;
    if (a != -1)
    {
        int i = 0;
        for (int j = 0; j < n; j++)
        {
            if (j != a - 2 && j != b - 1 && j != a && j != b && j != a + 2 && j != b + 1)
            {
                cout << j << endl;
                pos[i] = j;
                i++;
            }
        }
        if (i != 0)
        {
            for (int x = 0; x < n; x++)
            {
                for (int y = 0; y < n; y++)
                {
                    arr[x][y] = '0';
                }
            }
            arr[a][0] = 'Q';
            arr[b][1] = 'Q';
            for (int l = 0; l < i; l++)
            {
                int k = pos[l];
                arr[k][2] = 'X';
            }
            for (int x = 0; x < n; x++)
            {
                for (int y = 0; y < n; y++)
                {
                    cout << arr[x][y] << " ";
                }
                cout << endl;
            }
        }
        if (i == 0)
        {
            printf("Empty list\n");
            for (int x = 0; x < n; x++)
            {
                for (int y = 0; y < n; y++)
                {
                    arr[x][y] = '0';
                }
            }
            arr[a][0] = 'Q';
            arr[b][1] = 'Q';
            for (int x = 0; x < n; x++)
            {
                for (int y = 0; y < n; y++)
                {
                    cout << arr[x][y] << " ";
                }
                cout << endl;
            }
        }
    }

    if (a == -1)
    {
        for (int i = 0; i < n; i++)
        {
            cout << i << endl;
        }
        for (int x = 0; x < n; x++)
        {
            for (int y = 0; y < n; y++)
            {
                if (y == 0)
                {
                    arr[x][y] = 'X';
                }
                else
                {
                    arr[x][y] = '0';
                }
            }
        }
        for (int x = 0; x < n; x++)
        {
            for (int y = 0; y < n; y++)
            {
                cout << arr[x][y] << " ";
            }
            cout << endl;
        }
    }
}

int main()
{
    getposition();
    return 0;
}