//
//  SECEventManager.swift
//  SEC Challenge
//
//  Created by SEC2018 on 9/19/18.
//  Copyright © 2018 SEC2018. All rights reserved.
//

import Foundation

class SECEventManager: EventManager {
    
    /**
     Network manager that handles request to "backend"
     */
    let networkManager: NetworkManager
    
    init(networkManager: NetworkManager) {
        self.networkManager = networkManager
    }
    
    func getEvents(completion: ([SECEvent]?) -> ()) {
        networkManager.getEvents { [unowned self] (response) in
            completion(self.parse(json: response))
        }
    }
    
    func findEvents(withName name: String) -> [SECEvent] {
        // TODO: add your implementation for this method
        return []
    }
    
    func findEvents(from: Date, to: Date) -> [SECEvent] {
        // TODO: add your implementation for this method
        return []
    }
    
    func findEvents(fromSpeaker: SECSpeaker) -> [SECEvent] {
        // TODO: add your implementation for this method
        return []
    }
}

// MARK: event manager helpers
extension SECEventManager {
    
    typealias FileContents = [String:[[String:Any]]]
    
    /**
     Returns array of **SECEvent** items from JSON
     
     - parameter json: Dictionary containing event info
    */
    func parse(json: FileContents) -> [SECEvent]? {
        let parser: JSONParser = SECEventJSONParser()
        return parser.parsed(json: json) as? [SECEvent]
    }
}
