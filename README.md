# BaseScript - Woodcutting

This script has been created using my own implementation of a Behaviour Tree (BT). A BT can be expressed as a hierarchal series of nodes *(Though in this repository, they derive from a base class called "Task")*. These nodes can be described as three types:

 1. **Control Flow** - *used to control which execution path to take down a tree.*
 2. **Execution** - *the "doers" of the script. These are your interaction points with the game world*.
 3. **Decorator** - *a type of utility which "extends" other node types*.

In this example script you will see all three types of nodes being used at some point.


## Why Behaviour trees?
### Reactivity
Why Behavior Trees? Behaviour trees are very "reactive" to changes in the game world. You're most likely currently writing scripts incorporating a **Finite State Machine** (FSM), which are usually excel at accomplishing small tasks with few states (think: WoodCuttingState and DroppingState or BankingState). Each state has a *finite* numbers of states it can switch or **transition** to. You usually have to do work up front to determine the triggers, and the implementation of this transition.

BTs on the other hand are written from the ground up around triggers in the game world, and if designed correctly, can handle transitions without any explicit code for them. If a random event was to spawn, or you were to enter combat, assuming a well structured tree, you can re-act (dismiss, run, or fight) without an explicit transition between states.

### Reusability
If nodes are carefully constructed , they can be re-used easily across scripts. As your node "library" increases, most of your time will end up designing your BTs and wiring up existing nodes.
Additionally, you will see in this example, I have created "Subtrees" which are a collection of nodes that can be re-used in a script, such as a Banking Subtree.
Typically BTs have an editor that will allow even non-programmers to be able to design these trees.
