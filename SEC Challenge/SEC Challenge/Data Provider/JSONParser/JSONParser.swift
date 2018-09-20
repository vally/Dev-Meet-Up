//
//  JSONParser.swift
//  SEC Challenge
//
//  Created by SEC2018 on 9/19/18.
//  Copyright © 2018 SEC2018. All rights reserved.
//

import Foundation

protocol JSONParser {
    
    typealias SingleItemJSON = [String:[[String:Any]]]?
    typealias ArrayOfDictionariesJSON = [[String:Any]]?
    
    /**
     Returns **Array** of parsed elements
    */
    func parsed(json: SingleItemJSON) -> [Any]?
}
