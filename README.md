# exploring-spring
Exploring Spring Framework

## Dev Tunnel
1. Launch a linux host with a public IP address and/or name resolvable by DNS.
2. Launch inbound tunnel (recieves request from browser/client) between linux host and laptop (dev. env.).
```bash
ssh -R 9080:localhost:8080 -i ~/.ssh/azure.pem ubuntu@openai
```
3. Firewall
Enable and start firewalld, if not already enabled and started.
```bash
systemctl status firewalld
systemctl enable firewalld
systemctl start firewalld
```
Open ports 80 and 443.
```bash
firewall-cmd --list-ports
firewall-cmd --permanent --add-port=9080/tcp
firewall-cmd --permanent --add-port=10080/tcp
firewall-cmd --reload
```
Forward ports 80 to 8080, and 443 to 8443.
```bash
firewall-cmd --list-forward-ports
firewall-cmd --permanent --add-forward-port=port=10080:proto=tcp:toport=9080
firewall-cmd --permanent --add-forward-port=port=443:proto=tcp:toport=8443
firewall-cmd --reload
```
3. Launch outbound tunnel (makes browser request) between the other/same laptop and linux host.
```bash
ssh -L 10080:localhost:9080 -i ~/.ssh/ubuntu.pem ubuntu@54.184.138.65
```
4.
```
HTTP/1.1 200 Everything OK
Server: netcat
Content-Type: text/plain; charset=UTF-8

Hello World!

mkfifo reply
nc -kl 8765 < reply | nc 127.0.0.1 4567 > reply # listens on port 8765 and redirects to localhost:4567. Runs until C-c.
rm reply # cleanup after end

mknod backpipe p
nc -k -l -p 10080 < backpipe | tee -a in.log | nc localhost 9080 | tee -a out.log > backpipe

iptables -t nat -I PREROUTING -p tcp --dport 80 -j REDIRECT --to-ports 8080
See: https://stackoverflow.com/questions/43828853/forwarding-traffic-from-80-to-8080
```
See: [SSH Port Forwarding](https://unix.stackexchange.com/questions/115897/whats-ssh-port-forwarding-and-whats-the-difference-between-ssh-local-and-remot)
See: [Netcat Proxy Server](https://stackoverflow.com/questions/4053876/using-netcat-nc-as-an-http-proxy-server-and-monitor)

## Note(s)
```
config:
  checkstyle/checkstyle.xml
src/main/java:
  com/example/DefaultController.java
src/main/resources:
  application.properties
  public/index.html
src/test/java:
  com/example/DefaultControllerTest.java

```
