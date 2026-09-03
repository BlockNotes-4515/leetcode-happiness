/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function(...args) {
    /*
    let count=0;
    count=count+1;
    return count;
    */
    return args.length;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */