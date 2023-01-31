package spp.demo.command

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.HttpClient

import java.net.URL

/**
 * This class is used to demonstrate the `View Traces` command.
 * <p>
 * <b>Usage:</b>
 * Open the Source++ Command Palette with `Ctrl+Shift+S` and search for `View Traces`.
 * </p>
 * <p>
 * <b>Command source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/view-traces/plugin.kts">View Traces</a>
 * </p>
 */
@Controller("/command")
class ViewTraces {

    /**
     * Execute the `View Traces` command with your caret anywhere between lines 30 and 35 to see the traces for
     * the endpoint below. Executing this command will open a list of traces for the given endpoint. Clicking on a
     * trace will open the trace details.
     */
    @Get("/view-traces")
    fun entryEndpoint(): HttpResponse<Void> {
        HttpClient.create(URL("http://localhost:8080")).use { client ->
            client.toBlocking().retrieve("/command/view-traces/exit")
        }
        return HttpResponse.ok()
    }

    @Get("/view-traces/exit")
    fun exitEndpoint(): HttpResponse<String> {
        return HttpResponse.ok("Success")
    }
}
