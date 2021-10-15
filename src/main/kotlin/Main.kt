import java.awt.Desktop
import java.io.File
import javax.swing.JOptionPane

var tries = 0

fun main(args: Array<String>) {
    delete(File(args[0]))
}

private fun delete(file: File) {
    if (!file.exists()) return

    if (!file.delete()) {
        tries++

        if (tries >= 4) {
            JOptionPane.showMessageDialog(null, "Failed to delete mod file! You have to delete it manually")
            Desktop.getDesktop().open(file.parentFile)
            return
        }

        Thread.sleep((1000 * tries).toLong())

        delete(file)
    }
}