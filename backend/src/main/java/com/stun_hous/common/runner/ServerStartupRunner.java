package com.stun_hous.common.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 서버 시작 시 아스키 아트 배너와 서버 정보를 표시하는 Runner
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ServerStartupRunner implements ApplicationRunner {

    private final Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        displayServerInfo();
    }

    /**
     * 서버 정보를 표시합니다.
     */
    private void displayServerInfo() {
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            String port = environment.getProperty("server.port", "8080");
            String contextPath = environment.getProperty("server.servlet.context-path", "");
            String profile = environment.getActiveProfiles().length > 0
                ? String.join(", ", environment.getActiveProfiles())
                : "default";

            String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            StringBuilder info = new StringBuilder();
            info.append(" \n");
            info.append(" \n");
            info.append("   ███████╗████████╗██╗   ██╗███╗   ██╗   ██╗   ██╗ ██████╗ ██╗   ██╗███████╗\n");
            info.append("   ██╔════╝╚══██╔══╝██║   ██║████╗  ██║   ██║   ██║██╔═══██╗██║   ██║██╔════╝\n");
            info.append("   ███████╗   ██║   ██║   ██║██╔██╗ ██║   ████████║██║   ██║██║   ██║███████╗\n");
            info.append("   ╚════██║   ██║   ██║   ██║██║╚██╗██║   ██╔═══██║██║   ██║██║   ██║╚════██║\n");
            info.append("   ███████║   ██║   ╚██████╔╝██║ ╚████║   ██║   ██║╚██████╔╝╚██████╔╝███████║\n");
            info.append("   ╚══════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═══╝   ╚═╝   ╚═╝ ╚═════╝  ╚═════╝ ╚══════╝\n");
            info.append("\n");
            info.append("╔══════════════════════════════════════════════════════════════════════════════╗\n");
            info.append("                            📊 SERVER INFORMATION 📊                        \n");
            info.append("╚══════════════════════════════════════════════════════════════════════════════╝\n");
            info.append("\n");
            info.append("  🕐 Start Time    : ").append(currentTime).append("\n");
            info.append("  🌐 Host Address  : ").append(hostAddress).append("\n");
            info.append("  🔌 Port          : ").append(port).append("\n");
            info.append("  📁 Context Path : ").append(contextPath.isEmpty() ? "/" : contextPath).append("\n");
            info.append("  🎭 Profile       : ").append(profile).append("\n");
            info.append("  🚀 Status        : ").append("✅ RUNNING").append("\n");
            info.append("\n");
            info.append("╔════════════════════════════════════════════════════════════════════════════╗\n");
            info.append("                      🎉  SERVER STARTED SUCCESSFULLY! 🎉                    \n");
            info.append("╚════════════════════════════════════════════════════════════════════════════╝\n");
            info.append("\n");

            log.info("{}", info.toString());

        } catch (UnknownHostException e) {
            log.warn("호스트 정보를 가져올 수 없습니다: {}", e.getMessage());
        }
    }
}
