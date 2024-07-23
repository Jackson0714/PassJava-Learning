# 查看 docker service 的日志

要查看 Ubuntu 上 Docker 服务的日志，可以使用 journalctl 命令，该命令可以显示系统服务的日志记录。以下是查看 Docker 服务日志的步骤：

1. 打开终端并以管理员身份登录。

2. 运行以下命令以显示 Docker 服务的日志：

   ```
   sudo journalctl -u docker.service
   ```

   该命令将显示 Docker 服务的详细日志记录。您可以通过向上或向下滚动终端窗口来查看完整的日志记录。

3. 如果您只想查看最近的几个日志条目，请使用以下命令：

   ```
   sudo journalctl -u docker.service -n 50
   ```

   该命令将显示 Docker 服务的最近 50 条日志条目。

4. 如果您只想查看特定日期或时间之后的日志，请使用以下命令：

   ```
   sudo journalctl -u docker.service --since "2022-03-01" --until "2022-03-31"
   ```

   该命令将显示从 2022 年 3 月 1 日至 2022 年 3 月 31 日之间的 Docker 服务日志。

5. 如果您希望实时监视 Docker 服务的日志，请使用以下命令：

   ```
   sudo journalctl -u docker.service -f
   ```

   该命令将在终端窗口中实时显示 Docker 服务的日志。要停止日志监视，请按 Ctrl + C。

请注意，具体步骤可能因您的操作系统和配置而异。如果您遇到任何问题，请参阅 Docker 文档或向 Docker 社区寻求帮助。