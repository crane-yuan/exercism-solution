workflow "ci" {
  on = "push"
  resolves = ["Setup Java Action-1"]
}

action "Setup Java Action-1" {
  uses = "actions/setup-java@475978becf74a4aeff0e47eec6e2a4c4a330c548"
}
