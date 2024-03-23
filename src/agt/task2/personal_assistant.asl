// personal assistant agent 

/* Task 2 Start of your solution */

//initial rules

best_option(Option) :- (Option) == 0.
best_option(Option) :- (Option) == 1.
best_option(Option) :- (Option) == 2.

//initial beliefs

best_option(vibrations, 0).
best_option(blinds, 1).
best_option(lights, 2). 

//execution part

!start.

@start_plan
+!start : true <-
    .print("Agent assisting user");
    .wait(1000);
    !assist_user.

+!assist_user : true <-
    .print("just checking");
    .wait(1000);
    +upcoming_event("now");
    .print("There is an upcoming event, lets get going!");
    !manage_event.

@reacting_to_event_when_awake_plan
+!manage_event : upcoming_event("now") & owner_state("awake") <-
    .print("Enjoy your event.").

@reacting_to_event_when_asleep_plan
+!manage_event : upcoming_event("now") & owner_state("asleep") <-
    .print("Starting Wake Up Routine because upcoming event");
    !wake_up.

@wakeup_plan
+!wake_up : best_option(Option, _) & not used_option(Option) & owner_state("asleep") <-
    .print("Best case, wake up with ", Option);
    !execute_action(Option);
    .wait(1000);
    !check_on_owner.

+!execute_action(Option) : Option == vibrations <-
    .print("Setting mattress to vibrating");
    setVibrationsMode;
    +used_option(Option).

+!execute_action(Option) : Option == blinds <-
    .print("Raising blinds");
    raiseBlinds;
    +used_option(Option).

+!execute_action(Option) : Option == lights <-
    .print("Turning on lights");
    turnOnLights;
    +used_option(Option).

@the_user_awake
+!check_on_owner : owner_state("awake") <-
    .print("Owner is awake and my job is done here").

@the_user_asleep
+!check_on_owner : owner_state("asleep") <-
    .print("Owner is still asleep, lets try something else");
    .wait(1000);
    !wake_up.

//Plans in case of addition or deletion of beliefs

@lights_plan
+lights(State) : true <- 
    .print("The lights are ", State).

@blinds_plan
+blinds(State) : true <- 
    .print("The blinds are ", State).

@mattress_plan
+mattress(State) : true <- 
    .print("The mattress is ", State).

@owner_plan
+owner_state(State) : true <- 
    .print("The owner is ", State).

/* Task 2 End of your solution */

/* Import behavior of agents that work in CArtAgO environments */
{ include("$jacamoJar/templates/common-cartago.asl") }