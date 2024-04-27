在CentOS 9上设置静态IP地址，你可以使用NetworkManager来完成。以下是通过命令行设置静态IP地址的步骤：

1. 使用`nmcli`命令列出可用的网络连接：

```bash
nmcli connection show
```

2. 选择你要设置静态IP地址的连接，一般是你的以太网连接。假设它的名称是`eth0`。

3. 设置静态IP地址、网关和DNS。以下命令设置静态IP地址为`192.168.1.100`，子网掩码为`24`，网关为`192.168.1.1`，DNS为`8.8.8.8`：

```bash
sudo nmcli connection modify eth0 ipv4.method manual ipv4.addresses 192.168.1.100/24 ipv4.gateway 192.168.1.1 ipv4.dns 8.8.8.8

sudo nmcli connection modify enp0s5 ipv4.method manual ipv4.addresses 192.168.31.100/24 ipv4.gateway 192.168.31.1 ipv4.dns 8.8.8.8
```

记得将IP地址、子网掩码、网关和DNS替换为你的网络配置。

4. 重新启动网络连接：

```bash
sudo nmcli connection up eth0
sudo nmcli connection up enp0s5
```

现在，你的CentOS 9系统应该已经配置了静态IP地址。你可以通过`ifconfig`或者`ip addr`命令来验证设置是否生效。