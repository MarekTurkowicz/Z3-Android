import java.util.Date
import java.util.UUID

class Task(
    var id: UUID = UUID.randomUUID(),
    var name: String = "",
    var date: Date = Date(),
    var done: Boolean = false

)
