1. Log into the User account on the Windows XP virtual machine
2. Open Regedit
3. Go to `HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\WindowsNT\CurrentVersion\Winlogon\SpecialAccounts\UserList`
4. Go to Edit -> New... -> DWORD Value
5. Type `Administrator` as the name
6. Right-click `Administrator`, then click Modify
7. Type `1` as the value data
8. Exit Regedit
9. Restart the virtual machine
10. Log into the Administrator account on the Windows XP virtual machine (Password: `692786`)
11. Download [LSASecretsDump](http://www.nirsoft.net/toolsdownload/lsasecretsdump.zip)
12. Extract `lsasecretsdump.zip`
13. Move `lsasecretsdump.exe` to C:\
14. Open Command Prompt
15. Type the following commands:
  * cd ..
  * cd ..
  * lsasecretsdump
16. Look under DefaultPassword, you'll find `o.h._.h.o.w._.v.i.r.u.s.e.s._.g.o.`
17. The flag is **{oh_how_viruses_go}**
