#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;

// template {{{  0 
// using {{{ 1
using ll = long long int;
using pii = pair<int,int>;
using pll = pair<ll,ll>;
using vi = vector<int>;
using vl = vector<ll>;
using vii = vector<pii>;
using vll = vector<pll>;
// }}} 1
// definition {{{ 1
// scaning {{{ 2
#define Scd(x) scanf("%d", &x)
#define Scd2(x,y) scanf("%d%d", &x, &y)
#define Scd3(x,y,z) scanf("%d%d%d", &x, &y, &z)
#define Scll(x) scanf("%lld", &x)
#define Scll2(x,y) scanf("%lld%lld", &x, &y)
#define Scll3(x,y,z) scanf("%lld%lld%lld", &x, &y, &z)
#define Scc(c) scanf("%c", &c);
#define Scs(s) scanf("%s", s);
#define Scstr(s) scanf("%s", &s);
// }}} 2
// constants {{{ 2
#define EPS (1e-7)
#define INF (2e9)
#define PI (acos(-1))
// }}} 2
// systems {{{ 2
#define Repe(x,y,z) for(ll x = z; x < y; x++)
#define Rep(x,y) Repe(x,y,0)
#define RRepe(x,y,z) for(ll x = y-z-1; x >= 0; x--)
#define RRep(x,y) RRepe(x,y,0)
// }}} 2
// output {{{ 2
#define YesNo(a) (a)?printf("Yes\n"):printf("No\n")
#define YESNO(a) (a)?printf("YES\n"):printf("NO\n")
// }}} 2
// }}} 1
// input {{{ 1
// }}} 1
// }}} 0

void PrintOut( char* sun, char* shade){
    const int H = 14;
    const int W = 11;
    int kusaBit[H] = {
        0b00000000000,
        0b00100000100,
        0b11111111111,
        0b00100000100,
        0b00011111000,
        0b00010001000,
        0b00011111000,
        0b00010001000,
        0b00011111000,
        0b00000100000,
        0b01111111110,
        0b00000100000,
        0b00000100000,
        0b00000000000
    };
    for( int i = 0; i < H; i++ ){
        for( int j = 0; j < W; j++ ){
            printf (":%s:", kusaBit[i]&(1<<j)?sun:shade);
        }
        printf ("\n");
    }
}

int main() {

    char s[123],t[123];
    Scs(s); Scs(t);
    PrintOut(s,t);

    return 0;
}



