rootProject.name = "secretSanta"

include("group")
project(":group").projectDir = file("applications/group")

include("ui")
project(":ui").projectDir = file("applications/groupUi/server")

include("admin")
project(":admin").projectDir = file("applications/admin")

include("group")
project(":group").projectDir = file("applications/group")