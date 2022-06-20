package com.coderodde;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import com.github.coderodde.util.IndexedLinkedList;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.apache.commons.collections4.list.TreeList;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
public class IndexedLinkedListPerformance {

    private static final int ADD_FIRST_OPERATIONS           = 20_000;
    private static final int ADD_LAST_OPERATIONS            = 20_000;
    private static final int ADD_AT_OPERATIONS              = 10_000;
    private static final int ADD_COLLECTION_AT_OPERATIONS   = 2_000;
    private static final int ADD_COLLECTION_OPERATIONS      = 4_000;
    private static final int REMOVE_COLLECTION_SIZE         = 50_000;
    private static final int REMOVE_OBJECT_OPERATIONS       = 15_000;
    private static final int GET_SIZE                       = 25_000;
    private static final int GET_OPERATIONS                 = 10_000;
    
    
    private static final int MAXIMUM_INTEGER         = 1_000;
    private static final int MAXIMUM_COLLECTION_SIZE = 20;
    
    private static final long seed = System.currentTimeMillis();
    
    //// State get /////////////////////////////////////////////////////////////
    @State(Scope.Benchmark)
    public static class IndexedLinkedListStateGet {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new IndexedLinkedList<>();
            random = new Random(seed);
            
            for (int i = 0; i < GET_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class ArrayListStateGet {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new ArrayList<>();
            random = new Random(seed);
            
            for (int i = 0; i < GET_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class LinkedListStateGet {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new LinkedList<>();
            random = new Random(seed);
            
            for (int i = 0; i < GET_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class TreeListStateGet {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new TreeList<>();
            random = new Random(seed);
            
            for (int i = 0; i < GET_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    //// State removeFirst /////////////////////////////////////////////////////
    @State(Scope.Benchmark)
    public static class IndexedLinkedListStateRemoveFirst {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new IndexedLinkedList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class ArrayListStateRemoveFirst {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new ArrayList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class LinkedListStateRemoveFirst {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new LinkedList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class TreeListStateRemoveFirst {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new TreeList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    //// State removeFirst /////////////////////////////////////////////////////
    @State(Scope.Benchmark)
    public static class IndexedLinkedListStateRemoveLast {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new IndexedLinkedList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class ArrayListStateRemoveLast {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new ArrayList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class LinkedListStateRemoveLast {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new LinkedList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class TreeListStateRemoveLast {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new TreeList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    //// State removeAt ////////////////////////////////////////////////////////
    @State(Scope.Benchmark)
    public static class IndexedLinkedListStateRemoveAt {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new IndexedLinkedList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class ArrayListStateRemoveAt {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new ArrayList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class LinkedListStateRemoveAt {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new LinkedList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class TreeListStateRemoveAt {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new TreeList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////

    
    //// State removeObject ////////////////////////////////////////////////////
    @State(Scope.Benchmark)
    public static class IndexedLinkedListStateRemoveObject {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new IndexedLinkedList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class ArrayListStateRemoveObject {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new ArrayList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class LinkedListStateRemoveObject {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new LinkedList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    
    @State(Scope.Benchmark)
    public static class TreeListStateRemoveObject {
        public List<Integer> list;
        public Random random;
        
        @Setup(Level.Trial)
        public void setup() {
            list = new TreeList<>();
            random = new Random(seed);
            
            for (int i = 0; i < REMOVE_COLLECTION_SIZE; ++i) {
                list.add(i);
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////

    private static Integer getRandomInteger(Random random) {
        return random.nextInt(MAXIMUM_INTEGER + 1);
    }
 
    //// profileAddFirst ///////////////////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileRoddeListAddFirst() {
        profileAddFirst(new IndexedLinkedList<>(), ADD_FIRST_OPERATIONS);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileLinkedListAddFirst() {
        profileAddFirst(new LinkedList<>(), ADD_FIRST_OPERATIONS);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileArrayListAddFirst() {
        System.out.println(System.getProperty("file.encoding"));
        profileAddFirst(new ArrayList<>(), ADD_FIRST_OPERATIONS);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileTreeListAddFirst() {
        profileAddFirst(new TreeList<>(), ADD_FIRST_OPERATIONS);
    }
    ////////////////////////////////////////////////////////////////////////////
 
    
    //// profileAddLast ////////////////////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileRoddeListAddLast() {
        profileAddLast(new IndexedLinkedList<>(), ADD_LAST_OPERATIONS);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileLinkedListAddLast() {
        profileAddLast(new LinkedList<>(), ADD_LAST_OPERATIONS);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileArrayListAddLast() {
        profileAddLast(new ArrayList<>(), ADD_LAST_OPERATIONS);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileTreeListAddLast() {
        profileAddLast(new TreeList<>(), ADD_LAST_OPERATIONS);
    }
    ////////////////////////////////////////////////////////////////////////////
 
    
    //// profileAddAtIndex ////////////////////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileRoddeListAddAtIndex() {
        profileAddAtIndex(new IndexedLinkedList<>(), ADD_AT_OPERATIONS);
        
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileLinkedListAddAtIndex() {
        profileAddAtIndex(new LinkedList<>(), ADD_AT_OPERATIONS);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileArrayListAddAtIndex() {
        profileAddAtIndex(new ArrayList<>(), ADD_AT_OPERATIONS);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileTreeListAddAtIndex() {
        profileAddAtIndex(new TreeList<>(), ADD_AT_OPERATIONS);
    }
    ////////////////////////////////////////////////////////////////////////////
 
    
    //// profileAddCollection //////////////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileRoddeListAddCollection() {
        Random random = new Random(seed + 2);
        profileAddCollection(new IndexedLinkedList<>(),
                             ADD_COLLECTION_OPERATIONS, 
                             random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileLinkedListAddCollection() {
        Random random = new Random(seed + 2);
        profileAddCollection(new LinkedList<>(),
                             ADD_COLLECTION_OPERATIONS, 
                             random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileArrayListAddCollection() {
        Random random = new Random(seed + 2);
        profileAddCollection(new ArrayList<>(),
                             ADD_COLLECTION_OPERATIONS, 
                             random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileTreeListAddCollection() {
        Random random = new Random(seed + 2);
        profileAddCollection(new TreeList<>(),
                             ADD_COLLECTION_OPERATIONS, 
                             random);
    }
    ////////////////////////////////////////////////////////////////////////////
 
    
    //// profileAddCollectionAtIndex ///////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileRoddeListAddCollectionAtIndex() {
        Random random = new Random(seed + 2);
        profileAddCollectionAtIndex(new IndexedLinkedList<>(),
                                    ADD_COLLECTION_AT_OPERATIONS, 
                                    random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileLinkedListAddCollectionAtIndex() {
        Random random = new Random(seed + 2);
        profileAddCollectionAtIndex(new LinkedList<>(),
                                    ADD_COLLECTION_AT_OPERATIONS, 
                                    random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileArrayListAddCollectionAtIndex() {
        Random random = new Random(seed + 2);
        profileAddCollectionAtIndex(new ArrayList<>(),
                                    ADD_COLLECTION_AT_OPERATIONS, 
                                    random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileTreeListAddCollectionAtIndex() {
        Random random = new Random(seed + 2);
        profileAddCollectionAtIndex(new TreeList<>(),
                                    ADD_COLLECTION_AT_OPERATIONS, 
                                    random);
    }
    ////////////////////////////////////////////////////////////////////////////
 
    
    //// profileRemoveAt ///////////////////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileRoddeListRemoveAtIndex(
            IndexedLinkedListStateRemoveAt state,
            Blackhole blackhole) {
        
        profileRemoveAt(state.list,
                        state.random,
                        blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileLinkedListRemoveAtIndex(LinkedListStateRemoveAt state,
                                               Blackhole blackhole) {
        profileRemoveAt(state.list,
                        state.random,
                        blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileArrayListRemoveAtIndex(ArrayListStateRemoveAt state,
                                              Blackhole blackhole) {
        
        profileRemoveAt(state.list,
                        state.random,
                        blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileTreeListRemoveAtIndex(TreeListStateRemoveAt state, 
                                             Blackhole blackhole) {
        
        profileRemoveAt(state.list,
                        state.random,
                        blackhole);
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    //// profileRemoveObject ///////////////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileRoddeListRemoveObject(
            IndexedLinkedListStateRemoveObject state,
            Blackhole blackhole) {
        
        profileRemoveObject(state.list, state.random, blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileLinkedListRemoveObject(LinkedListStateRemoveObject state,
                                              Blackhole blackhole) {
        
        profileRemoveObject(state.list, state.random, blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileArrayListRemoveObject(ArrayListStateRemoveObject state,
                                             Blackhole blackhole) {
        
        profileRemoveObject(state.list, state.random, blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileTreeListRemoveObject(TreeListStateRemoveObject state, 
                                            Blackhole blackhole) {
        
        profileRemoveObject(state.list, state.random, blackhole);
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    //// profileRemoveFirst ////////////////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileRoddeListRemoveFirst(
            IndexedLinkedListStateRemoveFirst state,
            Blackhole blackhole) {
        
        profileRemoveFirst(state.list, blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileLinkedListRemoveFirst(LinkedListStateRemoveFirst state,
                                              Blackhole blackhole) {
        
        profileRemoveFirst(state.list, blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileArrayListRemoveFirst(ArrayListStateRemoveFirst state,
                                            Blackhole blackhole) {
        
        profileRemoveFirst(state.list, blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileTreeListRemoveFirst(TreeListStateRemoveFirst state, 
                                           Blackhole blackhole) {
        
        profileRemoveFirst(state.list, blackhole);
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    //// profileRemoveLast /////////////////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileRoddeListRemoveLast(
            IndexedLinkedListStateRemoveLast state,
            Blackhole blackhole) {
        
        profileRemoveLast(state.list, blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileLinkedListRemoveLast(LinkedListStateRemoveLast state,
                                            Blackhole blackhole) {
        
        profileRemoveLast(state.list, blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileArrayListRemoveLast(ArrayListStateRemoveLast state,
                                           Blackhole blackhole) {
        
        profileRemoveLast(state.list, blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileTreeListRemoveLast(TreeListStateRemoveLast state, 
                                          Blackhole blackhole) {
        
        profileRemoveLast(state.list, blackhole);
    }
    ////////////////////////////////////////////////////////////////////////////

    
    //// profileAddCollectionToTail ////////////////////////////////////////////
//    @Benchmark
//    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
//    @Measurement(iterations = 1)
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    @Fork(value = 1)
//    public void profileRoddeListAddCollection(
//            IndexedLinkedListStateAddCollection state) {
//        
//        profileAddCollection(state.list, GET_OPERATIONS);
//    }
//    
//    @Benchmark
//    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
//    @Measurement(iterations = 1)
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    @Fork(value = 1)
//    public void profileLinkedListAddCollection(
//            LinkedListStateAddCollection state) {
//        
//        profileAddCollection(state.list, ADD_FIRST_OPERATIONS);
//    }
//    
//    @Benchmark
//    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
//    @Measurement(iterations = 1)
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    @Fork(value = 1)
//    public void profileArrayListAddCollection(
//            ArrayListStateAddCollection state) {
//        
//        profileAddCollection(state.list, ADD_FIRST_OPERATIONS);
//    }
//    
//    @Benchmark
//    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
//    @Measurement(iterations = 1)
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    @Fork(value = 1)
//    public void profileTreeListAddCollection(TreeListStateAddCollection state) {
//        
//        profileAddCollection(state.list, ADD_FIRST_OPERATIONS);
//    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    //// profileGet ////////////////////////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 0)
    public void profileRoddeListGet(IndexedLinkedListStateGet state,
                                    Blackhole blackhole) {
        profileGet(state.list,
                   GET_OPERATIONS,
                   state.random, 
                   blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileArrayListGet(ArrayListStateGet state, 
                                    Blackhole blackhole) {
        profileGet(state.list, 
                   GET_OPERATIONS, 
                   state.random, 
                   blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileLinkedListGet(LinkedListStateGet state,
                                     Blackhole blackhole) {
        profileGet(state.list, 
                   GET_OPERATIONS,  
                   state.random, 
                   blackhole);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void profileTreeListGet(TreeListStateGet state, 
                                   Blackhole blackhole) {
        
        profileGet(state.list, GET_OPERATIONS, state.random, blackhole);
    }
    ////////////////////////////////////////////////////////////////////////////
    
    /*
    //// AddCollection /////////////////////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void Benchmark_13_profileAddCollectionRoddeList(
            IndexedLinkedListState state) {
        profileAddCollection(state.list, 
                             ADD_LAST_COLLECTION_OPERATIONS, 
                             state.random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void Benchmark_14_profileAddCollectionArrayList(ArrayListState state) {
        profileAddCollection(state.list, 
                             ADD_LAST_COLLECTION_OPERATIONS, 
                             state.random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void Benchmark_15_profileAddCollectionLinkedList(LinkedListState state) {
        profileAddCollection(state.list, 
                             ADD_LAST_COLLECTION_OPERATIONS, 
                             state.random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void Benchmark_16_profileAddCollectionTreeList(TreeListState state) {
        profileAddCollection(state.list, 
                             ADD_LAST_COLLECTION_OPERATIONS, 
                             state.random);
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    //// profileAddCollectionAtIndex ///////////////////////////////////////////
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void Benchmark_17_profileAddCollectionAtIndexRoddeList(
            IndexedLinkedListState state) {
        profileAddCollectionAtIndex(state.list, 
                                    ADD_COLLECTION_AT_OPERATIONS, 
                                    state.random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void Benchmark_18_profileAddCollectionAtIndexArrayList(
            ArrayListState state) {
        profileAddCollectionAtIndex(state.list, 
                                    ADD_COLLECTION_AT_OPERATIONS, 
                                    state.random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void Benchmark_19_profileAddCollectionAtIndexLinkedList(
            LinkedListState state) {
        profileAddCollectionAtIndex(state.list, 
                                    ADD_AT_OPERATIONS, 
                                    state.random);
    }
    
    @Benchmark
    @Warmup(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    public void Benchmark_20_profileAddCollectionAtIndexTreeList(TreeListState state) {
        profileAddCollectionAtIndex(state.list, 
                                    ADD_AT_OPERATIONS, 
                                    state.random);
    }
    ////////////////////////////////////////////////////////////////////////////
    */
    
    
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .forks(0)
                .warmupForks(0)
                .warmupIterations(1)
                .warmupTime(TimeValue.seconds(2L))
                .measurementIterations(1)
                .measurementTime(TimeValue.seconds(2L))
                .jvmArgsPrepend("-server", "-Xms7G", "-Xmx7G")
                .shouldDoGC(true)
                .timeUnit(TimeUnit.MILLISECONDS)
                .syncIterations(false)
                .build();
        
        new Runner(opt).run();
    }
    
    // private methods:
    private void profileAddFirst(List<Integer> list, int operations) {
        for (int i = 0; i < operations; i++) {
            list.add(0, i);
        }
    }
    
    private void profileAddLast(List<Integer> list, int operations) {
        for (int i = 0; i < operations; i++) {
            list.add(i);
        }
    }
    
    private void profileAddCollection(List<Integer> list,
                                      int operations, 
                                      Random random) {
        for (int i = 0; i < operations; ++i) {
            List<Integer> col = getCollection(random);
            list.addAll(col);
        }
    }
    
    private void profileAddCollectionAtIndex(List<Integer> list,
                                             int operations, 
                                             Random random) {
        for (int i = 0; i < operations; ++i) {
            List<Integer> col = getCollection(random);
            int index = random.nextInt(list.size() + 1);
            list.addAll(index, col);
        }
    }
    
    private void profileRemoveAt(List<Integer> list,
                                 Random random, 
                                 Blackhole blackhole) {
        while (!list.isEmpty()) {
            int index = random.nextInt(list.size());
            Integer i = list.remove(index);
            blackhole.consume(i);
        }
    }
    
    private void profileRemoveObject(List<Integer> list,
                                     Random random, 
                                     Blackhole blackhole) {
        for (int i = 0; i < REMOVE_OBJECT_OPERATIONS; ++i) {
            Integer value = random.nextInt(REMOVE_COLLECTION_SIZE);
            list.remove((Object) value);
            blackhole.consume(value);
        }
    }
    
    private void profileRemoveFirst(List<Integer> list, Blackhole blackhole) {
        if (list instanceof Deque) {
            Deque<Integer> deque = (Deque<Integer>) list;
            
            while (!deque.isEmpty()) {
                Integer num = deque.removeFirst();
                blackhole.consume(num);
            }
        } else {
            while (!list.isEmpty()) {
                Integer num = list.remove(0);
                blackhole.consume(num);
            }
        }
    }
    
    private void profileRemoveLast(List<Integer> list, Blackhole blackhole) {
        if (list instanceof Deque) {
            Deque<Integer> deque = (Deque<Integer>) list;
            
            while (!deque.isEmpty()) {
                Integer num = deque.removeLast();
                blackhole.consume(num);
            }
        } else {
            while (!list.isEmpty()) {
                Integer num = list.remove(list.size() - 1);
                blackhole.consume(num);
            }
        }
    }
    
    private void profileAddAtIndex(List<Integer> list, int operations) {
        Random random = new Random(seed + 1L);
        
        for (int i = 0; i < operations; i++) {
            int index = random.nextInt(list.size() + 1);
            Integer value = getRandomInteger(random);
            list.add(index, value);
        }
    }
    
    private void profileGet(List<Integer> list,
                            int operations, 
                            Random random, 
                            Blackhole blackhole) {
        for (int i = 0; i < operations; i++) {
            Integer j = list.get(random.nextInt(list.size()));
            blackhole.consume(j);
        }
    }
    
    private static List<Integer> getCollection(Random random) {
        List<Integer> list = new ArrayList<>();
        int listSize = random.nextInt(MAXIMUM_COLLECTION_SIZE + 1);
        
        for (int i = 0; i < listSize; ++i) {
            list.add(i);
        }
        
        return list;
    }
}
