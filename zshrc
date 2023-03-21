#GIT include
alias ll='ls -al'

export CLICOLOR=1
export LSCOLORS=GxFxCxDxBxegedabagaced

autoload -U colors && colors

autoload -Uz compinit && compinit

autoload -Uz vcs_info
precmd_vcs_info() { vcs_info }
precmd_functions+=( precmd_vcs_info )
setopt prompt_subst

PROMPT="%F{214}%n%{$reset_color%}@%F{45}%m%{$reset_color%}"

PROMPT+=" %f➜"

PROMPT+=' %F{171}%3~%F{76} ${vcs_info_msg_0_}%F{255}%{$reset_color%}# '
#PROMPT+='${vcs_info_msg_0_}'
# PROMPT='${vcs_info_msg_0_}%# '
#zstyle ':vcs_info:git:*' formats '%b'
zstyle ':vcs_info:git*' formats "(%b)%a%m%u%c"
#zstyle ':vcs_info:git*' actionformats "%s  %r/%S %b %m%u%c "
zstyle ':completion:*' list-colors 'white'
