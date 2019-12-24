
" バックアップファイルを作らない
set nobackup
" スワップファイルを作らない
set noswapfile
" 編集中のファイルが変更されたら自動で読み直す
set autoread
" バッファが編集中でもその他のファイルを開けるように
set hidden
" 入力中のコマンドをステータスに表示する
set showcmd

"文字コード系
set encoding=utf-8
scriptencoding utf-8
" 保存時の文字コード
"set fileencoding=utf-8
" 読み込み時の文字コードの自動判別. 左側が優先される
"set fileencodings=ucs-boms,utf-8,euc-jp,cp932
" 改行コードの自動判別. 左側が優先される
"set fileformats=unix,dos,mac
" □や○文字が崩れる問題を解決"
"set ambiwidth=double
"ヤンクした時にクリップボードにコピーする
"set clipboard=unnamed,autoselect

" 見た目系
" 行番号を表示
set number
" 現在の行を強調表示
set cursorline
" インデントはスマートインデント
set smartindent
" 括弧入力時の対応する括弧を表示
set showmatch
set matchtime=1
" ステータスラインを常に表示
set laststatus=2
" コマンドラインの補完
set wildmode=list:longest
" 折り返し時に表示行単位での移動できるようにする
nnoremap j gj
nnoremap k gk


" Tab系
set expandtab
set fenc=utf-8
set virtualedit=onemore 
set autoindent
set smartindent 
set tabstop=4 
set shiftwidth=4 
set backspace=indent,eol,start "バックスペースでの行移動を可能にする


" 検索系
" 検索文字列が小文字の場合は大文字小文字を区別なく検索する
set ignorecase
" 検索文字列に大文字が含まれている場合は区別して検索する
set smartcase
" 検索文字列入力時に順次対象文字列にヒットさせる
set incsearch
" 検索時に最後まで行ったら最初に戻る
set wrapscan
" 検索語をハイライト表示
set hlsearch
" ESC連打でハイライト解除
nmap <Esc><Esc> :nohlsearch<CR><Esc>

" ショートカット再現
nmap <C-s> :update<CR>
inoremap <C-s> <Esc>:update<CR>
nmap <C-z> :u<CR>
inoremap <C-z> <Esc>:u<CR>i
nmap <C-y> :<C-r>
inoremap <C-y> <Esc><C-r>i

" 特殊ショートカット
inoremap <silent> jj <Esc>


" キーマッピング
inoremap {<Enter> {}<Left><CR><ESC><S-o>
inoremap ( ()<LEFT>
inoremap ' ''<LEFT>
inoremap " ""<LEFT>
" inoremap [ []<LEFT>
" inoremap < <><LEFT>
nmap <F4> :terminal g++ -std=gnu++14 -static -O3 -Wall %<CR>
nmap <F5> :terminal g++ -std=gnu++14 -static -O3 -Wall %<CR>i
nmap <F6> :terminal ./a.out <CR>i


" 頻出命令の短縮化（エンターを最後に押して実行）
inoremap <silent> for<Tab> for (int i = 0; i < m; i++)
inoremap <silent> printf<Tab> printf ("%d\n", a);


" コマンド置換
""nmap + <C-a>
""nmap - <C-x>
nmap <kPlus> <C-a>
nmap <kMinus> <C-x>


" コマンドの履歴追加
set history=2000

" 不可視文字の可視化
set list
set list listchars=tab:>-,trail:-


" マクロ作成済み

" 文字の色付け
syntax on
colo industry
au BufRead,BufNewFile *.cpp set filetype=cpp

" 折りたたみ有効
set foldmethod=marker

" テンプレート
autocmd BufNewFile *.cpp 0r ~/.vim/template/template.cpp


