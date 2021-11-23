from tkinter import *
import linux_devices as lin
import win_devices as win


class main_win(Tk):
    def __init__(self):
        super(main_win,self).__init__()

        self.title("TrustMapper Python")
        self.minsize(500,400)
        self.option_add('*tearOff', FALSE)

        

mw = main_win()
top_men = Menu(mw)
mw['menu'] =top_men

menu_file = Menu(top_men)
top_men.add_cascade(menu=menu_file, label='File')

menu_servers = Menu(top_men)
top_men.add_cascade(menu=menu_servers, label='Servers')
win_servs = Menu(menu_servers)
menu_servers.add_cascade(menu=win_servs, label='Windows Servers')
lin_servs = Menu(menu_servers)
menu_servers.add_cascade(menu=lin_servs, label='Linux Servers')

lin_servs.add_command(label="RHEL", command=lin.rhel_serv)

menu_clients = Menu(top_men)
top_men.add_cascade(menu=menu_clients, label='Clients')

menu_network = Menu(top_men)
top_men.add_cascade(menu=menu_network, label='Network')

mw.mainloop()