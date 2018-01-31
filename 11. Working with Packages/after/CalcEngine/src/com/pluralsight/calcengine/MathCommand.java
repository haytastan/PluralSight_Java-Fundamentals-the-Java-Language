package com.pluralsight.calcengine;

/**
 * Created by Jim on 10/18/2015.
 */
enum MathCommand {
    // we don't want other people (from other packages)
    // use the enum, so made it default (package private)
    Add,
    Subtract,
    Multiply,
    Divide
}
