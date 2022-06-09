package example.micronaut

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext

import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Parameters
import com.justai.jaicf.channel.ConsoleChannel
import com.justai.jaicf.examples.helloworld.helloWorldBot

@Command(name = "micronautguide", description = ["..."],
        mixinStandardHelpOptions = true)
class MicronautguideCommand : Runnable {

    @Option(names = ["-v", "--verbose"], description = ["..."])
    private var verbose : Boolean = false

    override fun run() {
        // business logic here
        if (verbose) {
            println("This demo shows how to build a native CLI bot using JAIF, Micronaut & Picocli.\n " +
                    "Only use 'yes' and 'no' to answer pet related questions (demo does not use NLU, only regex).")
        }
        println("Run with '-v' option for instructions. Ctrl+c to stop.")
        println("Type something in the console to start...")
        runConsoleChannel()
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(MicronautguideCommand::class.java, *args)
        }
    }
}

fun runConsoleChannel(){
    // Extend HttpBotChannelServlet and pass an instance of channel (as per JAIF Spring doc).
    // Pass a BotEngine implementation to the channel instance:
    ConsoleChannel(helloWorldBot).run()
}
