/*
 * Copyright 1990-2008, Mark Little, University of Newcastle upon Tyne
 * and others contributors as indicated 
 * by the @authors tag. All rights reserved. 
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors. 
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 * 
 * (C) 1990-2008,
 */

package org.javasim.tests.stats;

import org.javasim.stats.SimpleHistogram;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleHistogramUnitTest
{
    @Test
    public void test () throws Exception
    {
        SimpleHistogram hist = new SimpleHistogram(1.0, 100.0, 20);
        
        hist.setValue(10.0);
        hist.setValue(100.0);
        
        assertEquals(hist.numberOfBuckets(), 20);
        
        assertTrue(hist.sizeByName(10.0) == 1.0);
        
        hist.print();
        
        hist.saveState("build/test/hist.temp");
        
        hist.reset();
        
        assertEquals(hist.numberOfBuckets(), 20);
        
        hist.restoreState("build/test/hist.temp");
        
        assertEquals(hist.numberOfBuckets(), 20);
        
        hist = new SimpleHistogram(10.0, 1000.0, 4.0);
        
        assertTrue(hist.Width() == 4.0);
    }
}
