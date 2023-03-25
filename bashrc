c_cyan=`tput setaf 51`
c_red=`tput setaf 1`
c_green=`tput setaf 47`
c_end=`tput sgr0`
c_purple=`tput setaf 5`
c_orange=`tput setaf 221`

parse_git_branch ()
{
  color=""
  if git rev-parse --git-dir >/dev/null 2>&1
  then
    if git diff --quiet 2>/dev/null >&2
    then
      color="${c_cyan}"
    else
      color="${c_green}"
    fi
    gitver=${color}"("$(git branch 2>/dev/null| sed -n '/^\*/s/^\* //p')")"${c_end}
  else
    return 0
  fi
  echo -e $gitver
}

PS1='\[${c_green}\]cuongpq -> \[${c_orange}\]\w\[${c_end}\]:$(parse_git_branch) '
export LS_COLORS='di=1;34:ln=36:so=35:pi=33:ex=32:bd=34;46:cd=34;43:su=30;41:sg=30;46:tw=30;42:ow=13;1;0'
